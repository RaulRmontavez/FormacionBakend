package com.raul.block7crudvalidation.controller.dto;

import com.raul.block7crudvalidation.clases.Alumnos_Estudios;
import com.raul.block7crudvalidation.clases.Persona;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorOutputDto {
    private Integer id_profesor;

    private PersonaOutputDto persona;

    private String coments;

    private String branch;

    private List<StudentOutputDtoSimple> student;


}