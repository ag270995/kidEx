package com.assignment.core.advice;

import com.assignment.core.enums.Status;
import com.assignment.core.exception.BaseException;
import com.assignment.core.exception.ConflictException;
import com.assignment.core.exception.LimitExceededException;
import com.assignment.core.pojo.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@ControllerAdvice
public class ExceptionHandlingControllerAdvice {
    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response handleBadRequestException(HttpClientErrorException.BadRequest e) {
        return Response.getInstance(Status.FAILURE.getValue(), e.getMessage());
    }
    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Response handleBaseException(BaseException e) {
        return Response.getInstance(Status.FAILURE.getValue(), e.getMessage());
    }
    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public Response handleConflictException(ConflictException e) {
        return Response.getInstance(Status.FAILURE.getValue(), e.getMessage());
    }
    @ExceptionHandler(LimitExceededException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public Response handleLimitExceededException(LimitExceededException e) {
        return Response.getInstance(Status.FAILURE.getValue(), e.getMessage());
    }
}
