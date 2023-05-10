package com.raul.block7crudvalidation.controller.dto;

import com.raul.block7crudvalidation.clases.Profesor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Alumnos_EstudiosOutputDtoSimple {
    private Integer id_study;
    private String asignatura;
    private String comment;
    private Date initial_date;
    private Date finish_date;
}