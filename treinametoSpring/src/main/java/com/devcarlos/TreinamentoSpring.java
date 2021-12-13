package com.devcarlos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//@EnableAutoConfiguration
@SpringBootApplication
//@ComponentScan("com.devcarlos")
public class TreinamentoSpring {

    public static void main(String[] args) {
        SpringApplication.run(TreinamentoSpring.class, args);

    }
}
