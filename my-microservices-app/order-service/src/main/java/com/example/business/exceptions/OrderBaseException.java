package com.example.business.exceptions;

public class OrderBaseException extends RuntimeException {

    private static final long serialVersionUID = -7806029002430564887L;
    private String message;
    private int status;

    public OrderBaseException(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public OrderBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderBaseException(String message, int status, Throwable ex) {
        super(message, ex);
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
   }

    @Override
    public String toString() {
        return "{" +
                "message='" + getMessage() + '\'' +
                ", status='" + getStatus() + '\'' +
                '}';
    }
}
