package com.assignment.core.exception;

import com.assignment.core.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Data
public class BaseException extends RuntimeException {

    public BaseException(String message) {
        this.message = message;
    }

    protected String status = Status.FAILURE.getValue();
    protected String message = HttpStatus.INTERNAL_SERVER_ERROR.toString();
}
