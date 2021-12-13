package com.devcarlos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.devcarlos")    //   USEI O COMPONENTE SCAN PQ A CLASSE PRINCIPAL ESTAVA FORA DO PACOTE
public class ApplicationStart {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }
}
