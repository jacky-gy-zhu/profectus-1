package com.profectus.interview.domain.exception;

public class BusinessException extends Exception {

    public BusinessException(Throwable throwable) {
        super(throwable);
    }

    public BusinessException(String message) {
        super(message);
    }

}
