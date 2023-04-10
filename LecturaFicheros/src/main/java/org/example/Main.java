package org.example;

import javax.swing.*;
import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Persona> lineas = new ArrayList<Persona>();


    public static void main(String[] args) throws Throwable {


        System.out.println("///////////////////////////////////////////");
        System.out.println("Ejercicio Lectura de ficheros y filtrado con Stream");
        System.out.println("///////////////////////////////////////////");

        leerLineas();


    }

    public static void leerLineas() {
        ArrayList<String> error = new ArrayList<String>();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(fileChooser);

        String ruta = fileChooser.getSelectedFile().getAbsolutePath();
        File f = new File(ruta);

        try {
            System.out.println("Contenido del fichero:");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String texto = br.readLine();
            int linea = 0;
            String[] parts = texto.split(":");
            while (texto != null) {


                if (texto != null) {


                    parts = texto.split(":");


                    String nombre = "";
                    String ciudad = "";
                    String edad = "";

                    if (parts.length >= 1) {
                        nombre = parts[0];
                    }
                    if (parts.length >= 2) {
                        ciudad = parts[1];

                    } else {
                        ciudad = "desconocido";
                    }
                    if (parts.length >= 3) {
                        edad = parts[2];
                    } else {
                        edad = "desconocido";
                    }


                    if (ciudad == "") {
                        ciudad = "desconocido";
                    }

                    if (nombre != "") {
                        lineas.add(new Persona(nombre, ciudad, edad));

                    } else {
                        error.add("Linea: " + linea + " " + texto + " -> El nombre es obligatorio. Hay 3 espacios en el campo y esto se considera como blank.");
                    }
                }

                if (contarCaracteres(texto, ':') == 0) {
                    error.add("Linea: " + linea + " " + texto + " -> Faltan dos delimitadores de campo");
                } else if (contarCaracteres(texto, ':') == 1) {
                    error.add("Linea: " + linea + " " + texto + " -> Falta el último delimitador de campo (:).");
                }


                linea++;
                texto = br.readLine();

            }


            br.close();
            fr.close();

            for (Persona p : lineas) {
                System.out.println(p);
            }
            System.out.println("///////////////////////////////////////////");
        } catch (IOException e) {
            e.printStackTrace();

        }


        if (error.size() > 0) {
            System.out.println("ERRORES!");
            for (int i = 0; i < error.size(); i++)
                System.out.println(new InvalidLineFormatException().CapturaError(error.get(i)));
        }
        System.out.println("///////////////////////////////////////////");
        System.out.println("APARTADO A)");
        filtroPorEdad();
        System.out.println("///////////////////////////////////////////");

        System.out.println("///////////////////////////////////////////");
        System.out.println("APARTADO B)");
        filtroPorLetra();
        System.out.println("///////////////////////////////////////////");

        System.out.println("///////////////////////////////////////////");
        System.out.println("APARTADO C)");
        filtroPorCiudad();
        System.out.println("///////////////////////////////////////////");

        System.out.println("///////////////////////////////////////////");
        System.out.println("APARTADO D)");
        filtroPorBarcelona();
        System.out.println("///////////////////////////////////////////");

    }

    //método para calcular el número de veces que se repite un carácter en un String
    public static int contarCaracteres(String cadena, char caracter) {
        int posicion, contador = 0;
        //se busca la primera vez que aparece
        posicion = cadena.indexOf(caracter);
        while (posicion != -1) { //mientras se encuentre el caracter
            contador++;           //se cuenta
            //se sigue buscando a partir de la posición siguiente a la encontrada
            posicion = cadena.indexOf(caracter, posicion + 1);
        }
        return contador;
    }


    public static void filtroPorEdad() {
        lineas.stream()
                .filter(persona -> Integer.parseInt(persona.getEdadInt()) < 25 && Integer.parseInt(persona.getEdadInt()) > 0)
                .map(Persona::toString)
                .forEach(System.out::println);

    }

    public static void filtroPorLetra() {
        lineas.stream()
                .filter(persona -> persona.getName().charAt(0) != 'A' && persona.getName().charAt(0) != 'Á')
                .map(Persona::toString)
                .forEach(System.out::println);

    }

    public static void filtroPorCiudad() {
        System.out.println(lineas.stream()
                .filter(persona -> Integer.parseInt(persona.getEdadInt()) < 25 && Integer.parseInt(persona.getEdadInt()) > 0 && persona.getCiudad().equals("Madrid"))
                .findAny().get());

    }

    public static void filtroPorBarcelona() {

        System.out.println(lineas.stream()
                .filter(persona -> persona.getCiudad().equals("Barcelona") && Integer.parseInt(persona.getEdadInt()) < 25 && Integer.parseInt(persona.getEdadInt()) > 0)
                .findAny().get());
    }


}