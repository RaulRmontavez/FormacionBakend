package com.block5commandlinerunner.block5commandlinerunner;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Clase1 {
    public String imprimirHola() {
        String Texto = "Hola desde clase primaria";
        System.out.println(Texto);
        return Texto;
    }
}
