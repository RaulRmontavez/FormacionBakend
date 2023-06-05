package com.raul.block7crudvalidation.Application;

import com.raul.block7crudvalidation.clases.Persona;
import com.raul.block7crudvalidation.controller.dto.PersonaInputDto;
import com.raul.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.raul.block7crudvalidation.repository.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;

class PersonaServiceImplTest {
    @Mock
    private PersonaRepository personaRepository;// Instancia del CRUD a probar

    @InjectMocks
    private PersonaServiceImpl personaService;

    private  Persona persona = new Persona(1,"Admin","usuario1234.","Pepe","Castro","Correos","Jodar","Bombero",true,new Date(),"jpg",new Date());
    private  Persona persona1 = new Persona(2,"Admin","usuario1234.","Pepe","Castro","Correos","Jodar","Bombero",true,new Date(),"jpg",new Date());




    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        //Mockito.when(personaRepository.findById(3)).thenReturn(Optional.empty());
        //personaRepository.save(persona);
        //personaRepository.save(persona1);

    }

    @Test
    @DisplayName("Añadir una persona")
    void testCreatePerson() throws Exception {
        PersonaInputDto personaInputDto = new PersonaInputDto(4,"Admin","usuario1234.","Juan","Castro","Correos","Jodar",true,new Date(),"jpg",new Date());
        Persona person = new Persona(personaInputDto);
        //Cuando hacemos un save en addPersona, se le devuelve una Persona, haciendo así que no nos de un error
        Mockito.when(personaRepository.save(Mockito.any(Persona.class))).thenReturn(person);
        // Llamar al método addPersona
        PersonaOutputDto personaCrear = personaService.addPersona(personaInputDto);


        //Comprobamos que personaDevuelta no sea nula
        assertNotNull(personaCrear);
        verify(personaRepository, times(1)).save(any(Persona.class));

    }


    @Test
    @DisplayName("Buscar una persona")
    void testFindPerson() {
        Mockito.when(personaRepository.findById(1)).thenReturn(Optional.of(persona));
        Mockito.when(personaRepository.findById(2)).thenReturn(Optional.of(persona1));
        personaRepository.save(persona);
        PersonaOutputDto personaEncontrada = personaService.getPersonaById(1);

        assertNotNull(personaEncontrada.getId_persona());
        verify(personaRepository, times(1)).findById(1);
        verify(personaRepository, times(1)).save(any(Persona.class));
    }

    @Test
    @DisplayName("Update una persona")
    void testUpdatePerson() {
        // Prueba actualizar una persona existente
        personaRepository.save(persona);

        persona.setSurname("Rodriguez");
        personaRepository.save(persona);
        Mockito.when(personaRepository.findById(persona.getId_persona())).thenReturn(Optional.of(persona));
        Optional<Persona> personaEncontrada = personaRepository.findById(persona.getId_persona());
                assertEquals("Rodriguez", personaEncontrada.get().getSurname());
    }

    @Test
    public void testDeletePerson() {
        // Prueba eliminar una persona existente

       personaRepository.delete(persona);

        Mockito.when(personaRepository.findById(persona.getId_persona())).thenReturn(Optional.of(persona));
        Optional<Persona> personaEncontrada = personaRepository.findById(persona.getId_persona());
        assertNotNull(personaEncontrada.get().getId_persona());
    }

}