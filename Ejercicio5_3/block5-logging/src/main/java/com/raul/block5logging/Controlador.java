package com.raul.block5logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;


@RestController
public class Controlador {

    Logger logger = LoggerFactory.getLogger(Controlador.class);

    public void index()  {
        logger.info("El programa esta funcionando");
        logger.warn("Algo esta funcionando de manera incorrecta , guarda para no perder progreso");
        logger.debug("Hola");
        logger.trace("Trace");


    logger.error("Error Desastroso");



    }



}
