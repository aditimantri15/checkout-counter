package com.retail.checkout.counter.helper;

import com.retail.checkout.counter.entity.ProductEntity;
import com.retail.checkout.counter.model.Bill;
import com.retail.checkout.counter.model.BilledProduct;
import com.retail.checkout.counter.model.CheckoutProduct;
import com.retail.checkout.counter.model.CheckoutRequest;
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

    private static final int QUANTITY = 10;

    private static final Double TOTAL_PRICE = 200d;

    private static final Double TOTAL_TAX = 20d;

    public static List<Product> getProductList() {
        return Lists.newArrayList(new Product(ID, PRODUCT_NAME, PRICE, CATEGORY));
    }

    public static List<ProductEntity> getProductEntityList() {
        return Lists.newArrayList(getProductEntity());
    }

    public static CheckoutRequest getCheckoutRequest() {
        return new CheckoutRequest(Lists.newArrayList(getCheckoutProduct(), getCheckoutProduct()));
    }

    public static Bill getBill() {
        return new Bill(getBilledProducts(), TOTAL_PRICE, TOTAL_TAX);
    }

    private static List<BilledProduct> getBilledProducts() {
        return Lists.newArrayList(getBilledProduct(), getBilledProduct());
    }

    private static BilledProduct getBilledProduct() {
        return new BilledProduct(getProductEntity(), getCheckoutProduct());
    }

    private static ProductEntity getProductEntity() {
        return new ProductEntity(ID, PRODUCT_NAME, PRICE, getCategoryEntity(), TIMESTAMP, TIMESTAMP);
    }

    private static CheckoutProduct getCheckoutProduct() {
        return new CheckoutProduct(ID, QUANTITY);
    }
}
