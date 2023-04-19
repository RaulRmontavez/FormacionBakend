package com.raul.block6simplecontrollers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Controlador3 {

@Bean
    @Qualifier("bean1")
    public Persona crearPersona1(){
        return new Persona("Juan","Bedmar",15);
    }
    @Bean
    @Qualifier("bean2")
    public Persona crearPersona2(){
        return new Persona("Victor","Mancha real",15);
    }
    @Bean
    @Qualifier("bean3")
    public Persona crearPersona3(){
        return new Persona("Angel","Jodar",15);
    }
}
