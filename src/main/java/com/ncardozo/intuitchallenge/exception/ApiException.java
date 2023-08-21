package com.ncardozo.intuitchallenge.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message, Integer statusCode) {
        super(message);

        this.statusCode = statusCode;
    }

    private Integer statusCode;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        statusCode = statusCode;
    }
}
