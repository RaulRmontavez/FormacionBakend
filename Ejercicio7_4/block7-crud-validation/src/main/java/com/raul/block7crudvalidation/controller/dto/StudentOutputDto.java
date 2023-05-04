package com.raul.block7crudvalidation.controller.dto;

import com.raul.block7crudvalidation.clases.Alumnos_Estudios;
import com.raul.block7crudvalidation.clases.Persona;
import com.raul.block7crudvalidation.clases.Profesor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class StudentOutputDto {
    private Integer id_student;

    private Integer num_hours_week;
    private String coments;
    private Profesor profesor;
    private String branch;
    private List<Alumnos_Estudios> estudios;

    //Persona
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
}