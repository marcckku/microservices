package com.example.business.exceptions;

public class UserBaseException extends RuntimeException {

    private static final long serialVersionUID = -7806029002430564887L;
    private String message;
    private int status;

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public UserBaseException(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public UserBaseException(String message, int status, Throwable ex) {
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
