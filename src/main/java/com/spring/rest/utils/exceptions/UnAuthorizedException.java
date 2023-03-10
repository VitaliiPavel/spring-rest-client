package com.spring.rest.utils.exceptions;

public class UnAuthorizedException extends RuntimeException{
    public UnAuthorizedException() {
        super();
    }
    public UnAuthorizedException(String message) {
        super(message);
    }
}
