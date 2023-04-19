package com.raul.block6simplecontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controlador2 {

    @Autowired
    protected Controlador1 controlador1;


   @GetMapping("/controlador2/getPersona")
    public Persona conseguirPersona(){
        return controlador1.pasarPersona();

    }

    @GetMapping("/controlador2/getCiudades")
    public ArrayList<Ciudad> conseguirCiudades(){
        return controlador1.pasarCiudades();

    }




}
