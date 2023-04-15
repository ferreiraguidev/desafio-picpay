package com.example.lojistasservice.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.FORBIDDEN;


@RestControllerAdvice
public class RestExceptionHandler {


    @ResponseStatus(FORBIDDEN)
    @ExceptionHandler(LojistaTransferException.class)
    public ExceptionFilters maximumHoursException(final LojistaTransferException ex) {
        return ExceptionFilters.builder().message(ex.getMessage()).build();
    }
}
