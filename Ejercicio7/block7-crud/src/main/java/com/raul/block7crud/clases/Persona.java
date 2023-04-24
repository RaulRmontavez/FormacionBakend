package com.raul.block7crud.clases;

import com.raul.block7crud.controllers.dto.PersonaInputDto;
import com.raul.block7crud.controllers.dto.PersonaOutputDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Persona {
    @Id
    @GeneratedValue
    int id;
    String name;
    String edad;
    String poblacion;

    public Persona(int id) {
        this.id = id;
    }

    public Persona(PersonaInputDto persona) {
        id = persona.getId();
        name = persona.getName();
        edad = persona.getEdad();
        poblacion = persona.getPoblacion();
    }

    public PersonaOutputDto personaToPersonaOutputDto() {
        return new PersonaOutputDto(this.id, this.name, this.edad, this.poblacion);
    }
}
