package com.example.business.exceptions;


import org.springframework.http.HttpStatus;

public class EmailAlreadyExistsException  extends UserBaseException {

    private static final long serialVersionUID = -7806029002430564887L;

    public EmailAlreadyExistsException(String message, int status) {
        super(message, status);
    }

    public EmailAlreadyExistsException(String message) {
        super(message, HttpStatus.NOT_FOUND.value());
    }

    public EmailAlreadyExistsException(String message, Throwable cause) {
        super(message, HttpStatus.NOT_FOUND.value(), cause);
    }
}
