package com.example.business.exceptions;


import org.springframework.http.HttpStatus;


public class OrderNotFoundException extends OrderBaseException {

    private static final long serialVersionUID = 1L;

    public OrderNotFoundException(String message, int status) {
        super(message, status);
    }

    public OrderNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND.value());
    }

    public OrderNotFoundException(String message, Throwable cause) {
        super(message, HttpStatus.NOT_FOUND.value(), cause);
    }

}
