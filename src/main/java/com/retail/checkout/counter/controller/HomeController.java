package com.retail.checkout.counter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private static final String GREET_MESSAGE = "Hello! You are at the Checkout Counter";

    @GetMapping("/")
    public String greet() {
        return GREET_MESSAGE;
    }
}
