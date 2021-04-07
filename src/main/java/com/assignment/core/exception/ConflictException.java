package com.assignment.core.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends BaseException {
    public ConflictException() {
        this.status = super.getStatus();
        this.message = HttpStatus.CONFLICT.toString();
    }
    public ConflictException(String message) {
        this.status = super.getStatus();
        this.message = message;
    }
}
