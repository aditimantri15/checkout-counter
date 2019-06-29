package com.retail.checkout.counter.service.impl;

import com.retail.checkout.counter.dao.ProductDao;
import com.retail.checkout.counter.model.Product;
import com.retail.checkout.counter.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        productDao.findAll().forEach(productEntity -> products.add(new Product(productEntity)));
        return products;
    }
}
