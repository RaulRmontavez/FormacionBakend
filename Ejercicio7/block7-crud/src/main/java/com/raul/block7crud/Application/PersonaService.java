package com.raul.block7crud.Application;

import com.raul.block7crud.clases.Persona;
import com.raul.block7crud.controllers.dto.PersonaInputDto;
import com.raul.block7crud.controllers.dto.PersonaOutputDto;

import java.util.List;

public interface PersonaService {


    PersonaOutputDto addPersona(PersonaInputDto persona);
    PersonaOutputDto getPersonaById(int id);
    List<PersonaOutputDto> getPersonaByName(String name);
    List<PersonaOutputDto> getPersonaAll();
    void deletePersonaById( int id);
    Iterable<PersonaOutputDto> getAllPersonas(int pageNumber, int pageSize);
    PersonaOutputDto updatePersona(PersonaInputDto student);

}
