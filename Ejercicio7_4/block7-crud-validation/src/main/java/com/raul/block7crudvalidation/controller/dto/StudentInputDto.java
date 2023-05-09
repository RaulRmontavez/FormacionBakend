package com.raul.block7crudvalidation.controller.dto;

import com.raul.block7crudvalidation.clases.Alumnos_Estudios;
import com.raul.block7crudvalidation.clases.Persona;
import com.raul.block7crudvalidation.clases.Profesor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentInputDto {

    private Integer id_student;
    private Integer persona;
    private Integer num_hours_week;
    private String coments;
    private Integer profesor;
    private String branch;
    private List<Alumnos_Estudios> estudios;
}
