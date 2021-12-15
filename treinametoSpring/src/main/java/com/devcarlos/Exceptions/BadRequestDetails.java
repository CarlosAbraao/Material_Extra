package com.devcarlos.Exceptions;


// HANDLER GLOBAL PERSONALIZANDO DETALHES DA EXCEÇÃO

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BadRequestDetails {

    private String title;
    private int status;
    private String details;
    private String developerMessage;
    private LocalDateTime timeStamp;
}
