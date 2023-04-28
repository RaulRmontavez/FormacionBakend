package com.raul.block7crudvalidation.controller.dto;

import com.raul.block7crudvalidation.clases.Alumnos_Estudios;
import com.raul.block7crudvalidation.clases.Persona;
import com.raul.block7crudvalidation.clases.Profesor;
import com.raul.block7crudvalidation.clases.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Alumnos_EstudiosInputDto {

    private Integer id_study;
    private Profesor profesor;
    private Student student;
    private String asignatura;
    private String comment;
    private Date initial_date;
    Date finish_date;
}
