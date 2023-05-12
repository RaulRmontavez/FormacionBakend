package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CalculadoraTest {

    @Test
    @Disabled
    void suma() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.suma(32, 94);
        assertEquals(126,resultado);

    }

    @Test
    @DisplayName("Metodo de Resta")
    void resta() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.resta(97, 23);
        assertEquals(4,resultado);
    }

    @Test
    @Tag("avanzada")
    void division() {
        Calculadora calculadora = new Calculadora();
        double resultado = calculadora.division(20, 5);
        assertEquals(4,resultado);
    }

    @Test
    @Tag("avanzada")
    void multiplicacion() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.multiplicacion(100, 6);
        assertEquals(392,resultado);
    }
}