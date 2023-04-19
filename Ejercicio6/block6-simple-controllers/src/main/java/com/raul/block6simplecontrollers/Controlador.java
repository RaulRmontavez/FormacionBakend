package com.raul.block6simplecontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {

    @Autowired
    @Qualifier("bean1")
    protected Persona persona1;

    @Autowired
    @Qualifier("bean2")
    protected Persona persona2;

    @Autowired
    @Qualifier("bean3")
    protected Persona persona3;


    @GetMapping("/controlador/bean/{bean}")
    public Persona BeanPersona(@PathVariable String bean) {
        System.out.println(bean);
        switch (bean) {
            case ("bean1"):
                System.out.println(persona1);
                return persona1;


            case ("bean2"):
                System.out.println(persona2);
                return persona2;


            case ("bean3"):
                System.out.println(persona3);
                return persona3;


            default:
                return null;


        }


    }
}
