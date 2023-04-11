package org.example;

public class Persona {
    private String name;
    private String ciudad;
    private String edad;

    public Persona(String name, String ciudad, String edad) {
        this.name = name;
        this.ciudad = ciudad;
        this.edad = edad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEdad() {
        return edad;
    }

    public String getEdadInt() {
        if (edad == "desconocido") {
            edad = "0";
        }
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", edad='" + edad + '\'' +
                '}';
    }
}
