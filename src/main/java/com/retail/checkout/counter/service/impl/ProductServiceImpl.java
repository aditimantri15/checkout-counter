package com.retail.checkout.counter.service.impl;

import com.retail.checkout.counter.dao.ProductDao;
import com.retail.checkout.counter.entity.ProductEntity;
import com.retail.checkout.counter.exception.BadRequestException;
import com.retail.checkout.counter.model.Bill;
import com.retail.checkout.counter.model.CheckoutProduct;
import com.retail.checkout.counter.model.CheckoutRequest;
import com.retail.checkout.counter.model.Product;
import com.retail.checkout.counter.model.BilledProduct;
import com.retail.checkout.counter.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        productDao.findAll().forEach(productEntity -> products.add(new Product(productEntity)));
        return products;
    }

    @Override
    public Bill generateBill(CheckoutRequest checkoutRequest) {
        Set<Long> productIds = new HashSet<>();
        checkoutRequest.getCheckoutProducts().forEach(checkoutProduct ->
                productIds.add(checkoutProduct.getProductId()));
        List<ProductEntity> productEntities = productDao.getAllByIdIn(productIds);
        return calculateTotalAmount(checkoutRequest, productEntities);
    }

    private Bill calculateTotalAmount(CheckoutRequest checkoutRequest, List<ProductEntity> productEntities) {
        Map<Long, ProductEntity> productEntityMap = getProductEntityMap(productEntities);
        List<BilledProduct> billedProducts = new ArrayList<>();
        Double totalPrice = 0d;
        Double totalTax = 0d;
        for (CheckoutProduct checkoutProduct : checkoutRequest.getCheckoutProducts()) {
            ProductEntity productEntity = productEntityMap.get(checkoutProduct.getProductId());
            validateProductEntity(productEntity, checkoutProduct.getProductId());
            BilledProduct billedProduct = new BilledProduct(productEntity, checkoutProduct);
            billedProducts.add(billedProduct);
            totalPrice += billedProduct.getTotal();
            totalTax += billedProduct.getTotalTax();
        }
        return new Bill(billedProducts, totalPrice, totalTax);
    }

    private Map<Long, ProductEntity> getProductEntityMap(List<ProductEntity> productEntities) {
        return productEntities.stream().collect(Collectors.toMap(
                ProductEntity::getId,
                productEntity -> productEntity,
                (productEntity1, productEntity2) -> productEntity2));
    }

    private void validateProductEntity(ProductEntity productEntity, Long productId) {
        if (!Optional.ofNullable(productEntity).isPresent()) {
            LOG.error("Invalid Product Id: {}", productId);
            throw new BadRequestException("Invalid Product Id: " + productId);
        }
    }
}
