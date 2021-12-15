package com.devcarlos.handler;

import com.devcarlos.Exceptions.BadRequestDetails;
import com.devcarlos.Exceptions.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {
        // CASO VC TENHA UMA EXCEÇÃO DO TIPO BAD REQUEST VC RETORNA A MESSAGEM DETALHADA
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestDetails> BadRequestException(BadRequestException badRequestException){
        return new ResponseEntity<>(
                BadRequestDetails.builder()
                        .timeStamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad request exception, check the documentation")
                        .details(badRequestException.getMessage())
                        .developerMessage(badRequestException.getClass().getName()) // PACOTE + 
                        .build(), HttpStatus.BAD_REQUEST

        );
    }


}
