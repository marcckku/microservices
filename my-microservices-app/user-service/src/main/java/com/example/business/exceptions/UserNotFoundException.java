package com.example.business.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserBaseException {

    private static final long serialVersionUID = -7806029002430564887L;

    public UserNotFoundException(String message, int status) {
        super(message, status);
    }

    public UserNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND.value());
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, HttpStatus.NOT_FOUND.value(), cause);
    }
}
