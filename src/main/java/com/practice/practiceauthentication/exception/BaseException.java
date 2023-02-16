package com.practice.practiceauthentication.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends Exception{
    protected final Integer statusCode;
    protected final String message;
    protected final HttpStatus httpStatus;
    protected final Object[] arg = null;

    public BaseException(Integer statusCode, String message, HttpStatus httpStatus) {
        this.statusCode = statusCode;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
