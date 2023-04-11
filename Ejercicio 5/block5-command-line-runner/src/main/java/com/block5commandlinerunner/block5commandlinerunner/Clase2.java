package com.block5commandlinerunner.block5commandlinerunner;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Clase2 implements CommandLineRunner {


    public String imprimirHola() {
        String Texto = "Hola desde clase secundaria";
        System.out.println(Texto);
        return Texto;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}


