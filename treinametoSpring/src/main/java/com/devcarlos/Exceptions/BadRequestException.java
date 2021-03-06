package com.devcarlos.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// EXCEPTION PERSONALIZADA
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {


    public BadRequestException(String message) {
        super(message);
    }
}
