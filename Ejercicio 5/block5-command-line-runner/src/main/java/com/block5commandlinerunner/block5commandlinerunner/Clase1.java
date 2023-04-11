package com.block5commandlinerunner.block5commandlinerunner;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Clase1 {
    @PostConstruct
    public void imprimirHola() {
        System.out.println("Hola desde clase inicial");
    }
}
