package com.retail.checkout.counter.exception;

/**
 * Use for holding the bad request related exceptions
 */
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 5701022728772511201L;

    public BadRequestException(String message) {
        super(message);
    }
}
