package com.retail.checkout.counter.service;

import com.retail.checkout.counter.model.Bill;
import com.retail.checkout.counter.model.CheckoutRequest;
import com.retail.checkout.counter.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Bill generateBill(CheckoutRequest checkoutRequest);
}
