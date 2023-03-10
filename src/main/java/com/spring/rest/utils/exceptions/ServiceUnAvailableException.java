package com.spring.rest.utils.exceptions;

public class ServiceUnAvailableException extends RuntimeException {
    public ServiceUnAvailableException() {
        super();
    }

    public ServiceUnAvailableException(String message) {
        super(message);
    }
}
