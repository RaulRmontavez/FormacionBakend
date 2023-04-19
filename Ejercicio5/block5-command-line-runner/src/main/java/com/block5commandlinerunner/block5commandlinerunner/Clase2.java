package com.block5commandlinerunner.block5commandlinerunner;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static com.block5commandlinerunner.block5commandlinerunner.Block5CommandLineRunnerApplication.terceraClase;

@Component
public class Clase2 implements CommandLineRunner {


    public void imprimirHola() {
        String Texto = "Hola desde clase secundaria";
        System.out.println(Texto);
        terceraClase.AddList(Texto);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}


