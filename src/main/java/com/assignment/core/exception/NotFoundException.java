package com.assignment.core.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {
    public NotFoundException() {
        this.status = super.getStatus();
        this.message = HttpStatus.NOT_FOUND.toString();
    }

    public NotFoundException(String message) {
        this.status = super.getStatus();
        this.message = message;
    }


}
