package com.assignment.core.exception;

import org.springframework.http.HttpStatus;

public class LimitExceededException extends BaseException{
    public LimitExceededException() {
        this.status = super.getStatus();
        this.message = HttpStatus.UNPROCESSABLE_ENTITY.toString();
    }
    public LimitExceededException(String message) {
        this.status = super.getStatus();
        this.message = message;
    }
}
