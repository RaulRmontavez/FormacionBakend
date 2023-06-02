package com.raul.block7crudvalidation.Application;

import com.raul.block7crudvalidation.clases.Persona;
import com.raul.block7crudvalidation.repository.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PersonaServiceImplTest {
    @Mock
    private PersonaRepository personaRepository;// Instancia del CRUD a probar

    @InjectMocks
    private PersonaServiceImpl personaService;

    private Persona persona = new Persona(1,"Admin","usuario1234.","Pepe","Castro","Correos","Jodar","Bombero",true,new Date(),"jpg",new Date());



    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        personaRepository.save(persona);
    }

    @Test
    @DisplayName("Añadir una persona")
    void testCreatePerson() {
        when(personaRepository.findById(persona.getId_persona())).thenReturn(Optional.of(persona));

        Optional<Persona> personaEncontrada = personaRepository.findById(persona.getId_persona());

        assertNotNull(personaEncontrada.get().getId_persona());

    }

    @Test
    @DisplayName("Update una persona")
    void testUpdatePerson() {
        // Prueba actualizar una persona existente
        personaRepository.save(persona);

        persona.setSurname("Rodriguez");
        personaRepository.save(persona);
        when(personaRepository.findById(persona.getId_persona())).thenReturn(Optional.of(persona));
        Optional<Persona> personaEncontrada = personaRepository.findById(persona.getId_persona());
                assertEquals("Rodriguez", personaEncontrada.get().getSurname());
    }

    @Test
    public void testDeletePerson() {
        // Prueba eliminar una persona existente


       /* personaRepository.delete(persona);

        when(personaRepository.findById(persona.getId_persona())).thenReturn(Optional.of(persona));
        Optional<Persona> personaEncontrada = personaRepository.findById(persona.getId_persona());
        assertNotNull(personaEncontrada.get().getSurname());
   */ }

}