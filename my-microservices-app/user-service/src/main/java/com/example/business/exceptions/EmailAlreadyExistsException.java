package com.example.business.exceptions;


public class EmailAlreadyExistsException  extends UserBaseException {

    private static final long serialVersionUID = -7806029002430564887L;

    public EmailAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailAlreadyExistsException(String message, int status) {
        super(message, status);
    }
}
