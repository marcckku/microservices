package com.example.business.exceptions;

public class UserNotFoundException extends UserBaseException {

    private static final long serialVersionUID = -7806029002430564887L;

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(String message, int status) {
        super(message, status);
    }

}
