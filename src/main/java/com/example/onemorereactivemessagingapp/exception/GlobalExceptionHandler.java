package com.example.onemorereactivemessagingapp.exception;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TypeMismatchException.class)
    public HttpStatus handleTypeMismatchException(TypeMismatchException e) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Invalid value %s", e.getValue()));
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public HttpStatus handleWebExchangeBindException(WebExchangeBindException e) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
}
