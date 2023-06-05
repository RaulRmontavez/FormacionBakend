package com.raul.block7crudvalidation.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PersonaInputDto {

    private int id_persona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;

    private String city;
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;


    public PersonaInputDto(String usuario, String password, String name, String surname, String company_email, String city, boolean active, Date created_date, String imagen_url, Date termination_date) {
        this.usuario = usuario;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.company_email = company_email;
        this.city = city;
        this.active = active;
        this.created_date = created_date;
        this.imagen_url = imagen_url;
        this.termination_date = termination_date;
    }
}
