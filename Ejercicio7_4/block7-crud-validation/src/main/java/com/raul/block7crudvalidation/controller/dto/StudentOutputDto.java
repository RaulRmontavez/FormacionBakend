package com.raul.block7crudvalidation.controller.dto;

import com.raul.block7crudvalidation.clases.Alumnos_Estudios;
import com.raul.block7crudvalidation.clases.Persona;
import com.raul.block7crudvalidation.clases.Profesor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class StudentOutputDto {
    private Integer id_student;
    private Persona persona;
    private Integer num_hours_week;
    private String coments;
    private Profesor profesor;
    private String branch;
    private List<Alumnos_Estudios> estudios;
}