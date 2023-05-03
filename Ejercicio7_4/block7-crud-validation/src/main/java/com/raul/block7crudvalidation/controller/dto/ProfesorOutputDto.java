package com.raul.block7crudvalidation.controller.dto;

import com.raul.block7crudvalidation.clases.Alumnos_Estudios;
import com.raul.block7crudvalidation.clases.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProfesorOutputDto {
    private Integer id_profesor;

    private Persona persona;

    private String coments;

    private List<Alumnos_Estudios>  alumnosEstudios;

    private String branch;

    private List<Alumnos_Estudios> estudios;
}