package com.devcarlos.handler;

import com.devcarlos.Exceptions.BadRequestDetails;
import com.devcarlos.Exceptions.BadRequestException;
import com.devcarlos.Exceptions.ValidationExceptionDetails;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.annotation.ServletSecurity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2 // faz logs
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


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionDetails> handlerMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
      // log.info("Fields{}", methodArgumentNotValidException.getBindingResult().getFieldError().getField()); // LOG DE ERROS/DEBUG
   List<FieldError> fieldError = (List<FieldError>) methodArgumentNotValidException.getBindingResult().getFieldError();
   String fields = fieldError.stream().map(FieldError::getField).collect(Collectors.joining(","));
   String fieldsMessage = fieldError.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));

               return new ResponseEntity<>(
                ValidationExceptionDetails.builder()
                        .timeStamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad request exception, Invalid Fields")
                        .details(methodArgumentNotValidException.getMessage())
                        .developerMessage(methodArgumentNotValidException.getClass().getName()) // PACOTE +
                        .fields(fields)
                        .fieldsMessage(fieldsMessage)

                        .build(), HttpStatus.BAD_REQUEST

        );
    }

}
