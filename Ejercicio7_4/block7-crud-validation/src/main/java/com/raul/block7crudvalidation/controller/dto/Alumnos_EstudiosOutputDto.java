package com.raul.block7crudvalidation.controller.dto;

import com.raul.block7crudvalidation.clases.Alumnos_Estudios;
import com.raul.block7crudvalidation.clases.Persona;
import com.raul.block7crudvalidation.clases.Profesor;
import com.raul.block7crudvalidation.clases.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Alumnos_EstudiosOutputDto {
    private Integer id_study;
    private Profesor profesor;
    private Student student;
    private String asignatura;
    private String comment;
    private Date initial_date;
    Date finish_date;
}