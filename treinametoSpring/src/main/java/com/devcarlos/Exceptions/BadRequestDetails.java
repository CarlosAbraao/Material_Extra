package com.devcarlos.Exceptions;


// HANDLER GLOBAL PERSONALIZANDO DETALHES DA EXCEÇÃO

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
public class BadRequestDetails extends ExceptionsDetails {


}
