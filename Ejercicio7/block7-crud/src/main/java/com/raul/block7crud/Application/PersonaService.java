package com.raul.block7crud.Application;

import com.raul.block7crud.controllers.dto.PersonaInputDto;
import com.raul.block7crud.controllers.dto.PersonaOutputDto;

public interface PersonaService {


    PersonaOutputDto addPersona(PersonaInputDto persona);
    PersonaOutputDto getPersonaById(int id);
    void deletePersonaById( int id);
    Iterable<PersonaOutputDto> getAllPersonas(int pageNumber, int pageSize);
    PersonaOutputDto updatePersona(PersonaInputDto student);

}
