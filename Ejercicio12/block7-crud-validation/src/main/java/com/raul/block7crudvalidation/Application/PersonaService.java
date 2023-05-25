package com.raul.block7crudvalidation.Application;



import com.raul.block7crudvalidation.controller.dto.PersonaInputDto;
import com.raul.block7crudvalidation.controller.dto.PersonaOutputDto;

import java.util.HashMap;
import java.util.List;

public interface PersonaService {

    PersonaOutputDto addPersona(PersonaInputDto persona) throws Exception;
    PersonaOutputDto getPersonaById(int id);
    List<PersonaOutputDto> getPersonaByName(String name);
    Iterable<PersonaOutputDto> getAllPersonas(int pageNumber, int pageSize);
    PersonaOutputDto updatePersona(PersonaInputDto persona, int id);
    void deletePersonaById( int id);

}
