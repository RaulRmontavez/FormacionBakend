package com.raul.block7crud.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonaOutputDto {
    int id;
    String name;
    String edad;
    String poblacion;
}