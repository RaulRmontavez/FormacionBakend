package com.raul.block7crudvalidation.controller.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PersonaInputDto {
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;

    private String imagen_url;
    private Date created_date;
    private boolean active;
    private Date termination_date;
}
