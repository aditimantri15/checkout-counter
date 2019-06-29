package com.retail.checkout.counter.controller;

import com.retail.checkout.counter.model.Bill;
import com.retail.checkout.counter.model.CheckoutRequest;
import com.retail.checkout.counter.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Bill generateBill(@Valid @RequestBody CheckoutRequest checkoutRequest) {
        return productService.generateBill(checkoutRequest);
    }
}
