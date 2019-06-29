package com.retail.checkout.counter.helper;

import com.retail.checkout.counter.entity.ProductEntity;
import com.retail.checkout.counter.model.Product;
import org.assertj.core.util.Lists;

import java.sql.Timestamp;
import java.util.List;

import static com.retail.checkout.counter.helper.CategoryHelper.getCategoryEntity;

public class ProductHelper {

    private static final Long ID = 1L;

    private static final String PRODUCT_NAME = "product-A";

    private static final Double PRICE = 10d;

    private static final String CATEGORY = "category-A";

    private static final Timestamp TIMESTAMP = new Timestamp(System.currentTimeMillis());

    public static List<Product> getProductList() {
        return Lists.newArrayList(new Product(ID, PRODUCT_NAME, PRICE, CATEGORY));
    }

    public static List<ProductEntity> getProductEntityList() {
        return Lists.newArrayList(new ProductEntity(ID, PRODUCT_NAME, PRICE, getCategoryEntity(), TIMESTAMP, TIMESTAMP));
    }
}
