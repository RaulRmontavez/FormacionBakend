package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;


class CalculadoraTest {

    @Test
    @Disabled
    void suma() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.suma(32, 94);
        assertEquals(126,resultado);

    }

    @Test
    public void ejemploEqualTo() {

        // Pasa porque ambos arrays tienen la misma longitud y los objetos en las mismas posiciones
        assertThat(new String[] {"foo", "bar"}, is(equalTo(new String[] {"foo", "bar"})));
        // Falla porque en el matcher el array primero tiene el String bar y luego el foo
        assertThat(new String[] {"foo", "bar"}, is(equalTo(new String[] {"foo", "bar"})));
        // Pasa porque estamos negando la anterior
        assertThat(new String[] {"bar", "foo"}, is(not(equalTo(new String[] {"foo", "bar"}))));

    }

    @Test
    public void ejemploSameInstance() {

        String cadena = "cadena";
        String sameCadena = cadena;
        assertThat(cadena, is(sameInstance(sameCadena)));// Pasa

    }

  /*  @Test
    public void ejemploSameInstance() {

        String cadena = "cadena";
        int sameCadena = 32;
        assertThat(cadena, is(sameInstance(sameCadena)));// Falla

    }*/
  @Test
  public void ejemploInstanceOf() {

      assertThat("foo", is(not(instanceOf(Integer.class))));// Pasa porque no es instancia de Integer
      assertThat("foo", is(instanceOf(String.class))); // Pasa porque es instancia de String
      assertThat("foo", isA(String.class)); // Es abreviatura del caso anterior por lo que también pasa

  }
    @Test
    public void ejemploAny() {

        //assertThat("foo", is(not(any(Integer.class)))); No funciona porque "foo" es String no Integer
        assertThat("foo", is(any(String.class)));

    }

    @Test
    public void ejemploStartsWith() {

        assertThat("cadena bar restaurante", startsWith("cadena"));// Pasa porque empieza por "cadena"

    }

    /*@Test
    public void ejemploStartsWith() {

        assertThat("cadena bar restaurante", startsWith("foo"));// Falla porque la cadena no empieza por "foo"

    }*/
    @Test
    public void ejemploEndsWithCase() {

        assertThat("Helicoptero", startsWithIgnoringCase("HEL"));// Pasa porque el string "Helicoptero" empieza en "HE" pero: "He"

    }
    @Test
    public void testPrueba(){

        Calculadora calculadora1 = new Calculadora();
        assertThat("10 X 0 debe de ser 0", calculadora1.multiplicacion(10, 0), equalTo(0));

    }

    @Test
    public void ejemploEndsWith() {

        assertThat("cadena bar restaurante", endsWith("te"));// Pasa porque la cadena termina en "te"

    }

    @Test
    public void ejemploConstainsString() {

        assertThat("cadena bar restaurante", containsString("bar"));// Pasa porque la cadena contiene "bar"

    }

   /* @Test
    public void ejemploConstainsString() {

        assertThat("cadena bar restaurante", containsString("rar"));// Falla porque la cadena no contiene "rar"

    }*/

    @Test
    public void ejemploConstainsStringCase() {

        assertThat("cadena bar restaurante", containsStringIgnoringCase("BAR"));// Pasa porque la cadena contiene "BAR" en minúsculas

    }


    @Test
    public void ejemploStringContainsInOrder() {

        String sujetoDePruebas = "cadena";

        assertThat(sujetoDePruebas, stringContainsInOrder("c", "e", "a"));// Pasa porque el string "cadena" tiene esa secuencia de caracteres en ese orden

    }

    @Test
    public void ejemploStringContainsInOrderFallo() {

        String sujetoDePruebas = "cadena";

        assertThat(sujetoDePruebas, stringContainsInOrder("d", "a", "n"));// Falla porque el string "cadena" no tiene los caracteres en ese orden

    }
    @Test
    public void ejemploAllOf() {

        assertThat("cadena bar estuche", allOf(startsWith("cadena"), endsWith("he")));// Pasa la prueba ya que cumple los dos matchers

    }
    @Test
    public void ejemploanyOf() {

        assertThat("bareto barqueta rayo", anyOf(startsWith("hol"), endsWith("yo")));// Pasa la prueba ya que cumple el segundo match

    }

    @Test
    public void ejemploBoth() {

        assertThat("pan trozo canasta", both(startsWith("pan")).and(endsWith("sta")));// Pasa la prueba porque cumple ambos matchers

    }

    @Test
    public void ejemploEither() {

        assertThat("foo bar baz", either(startsWith("foo")).or(endsWith("baz")));

    }

    @Test
    public void ejemploHasItem() {

        assertThat(Arrays.asList("casa", "palmera", "jardin"), hasItem("bar"));
        assertThat(Arrays.asList("casa", "palmera", "jardin"), hasItem(startsWith("b")));

    }

    @Test
    public void ejemploHasItems() {

        assertThat(Arrays.asList("foo", "bar", "baz"), hasItems("bar", "baz"));
        assertThat(Arrays.asList("foo", "bar", "baz"), hasItems(endsWith("o"), endsWith("z")));

    }

    @Test
    public void ejemploBlankString() {

        String first = "   ";
        String second = "";
        String third = null;
        String fourth = "null";

        assertThat(first, blankString());//Pasa
        assertThat(second, blankString());//Pasa
        assertThat(third, blankString());//Falla
        assertThat(fourth, blankString());//Falla

    }
    @Test
    public void ejemploBlankOrNullString() {

        String first = "   ";
        String second = "";
        String third = null;
        String fourth = "null";

        assertThat(first, blankOrNullString());//Pasa
        assertThat(second, blankOrNullString());//Pasa
        assertThat(third, blankOrNullString());//Pasa
        assertThat(fourth, blankOrNullString());//Falla

    }

    @Test
    public void ejemploEmptyString() {

        String first = null;
        String second = "";
        String third = " ";
        String fourth = "null";

        assertThat(first, emptyString());//Pasa
        assertThat(second, emptyString());//Falla
        assertThat(third, emptyString());//Falla
        assertThat(fourth, emptyString());//Falla

    }

    @Test
    public void whenStringIsEmpty_thenCorrect() {

        String first = null;
        String second = "";
        String third = " ";
        String fourth = "null";

        assertThat(fourth, emptyOrNullString());//Pasa
        assertThat(second, emptyOrNullString());//Pasa
        assertThat(third, emptyOrNullString());//Falla
        assertThat(fourth, emptyOrNullString());//Falla

    }

    @Test
    public void ejemploPatron() {

        String first = "StringDePatron";

        assertThat(first, matchesPattern("[a-z]+"));

    }

   /* @Test
    public void ejemploEndsWith() {

        assertThat("cadena bar restaurante", endsWith("so"));// Falla porque la cadena no termina en "so"

    }*/

    @Test
    public void ejemploIsEqual() {

        assertThat("cadena", is("cadena"));
        assertThat("cadena", equalTo("cadena"));
//	assertThat("cadena", equalToIgnoringCase("CAdeNa"));
//  assertThat("cadena", equalToIgnoringWhiteSpace("    cadena  "));
        assertThat("cadena", is(equalTo("cadena")));

    }

    @Test
    public void ejemploNot() {

        assertThat("cadena", is(not("bar")));// Pasa

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