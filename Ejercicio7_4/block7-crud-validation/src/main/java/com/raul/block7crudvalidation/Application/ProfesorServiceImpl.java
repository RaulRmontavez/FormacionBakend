package com.raul.block7crudvalidation.Application;


import com.raul.block7crudvalidation.clases.Persona;
import com.raul.block7crudvalidation.clases.Profesor;
import com.raul.block7crudvalidation.clases.Student;
import com.raul.block7crudvalidation.controller.dto.PersonaInputDto;
import com.raul.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.raul.block7crudvalidation.controller.dto.ProfesorInputDto;
import com.raul.block7crudvalidation.controller.dto.ProfesorOutputDto;
import com.raul.block7crudvalidation.exceptions.EntityNotFoundException;
import com.raul.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.raul.block7crudvalidation.repository.PersonaRepository;
import com.raul.block7crudvalidation.repository.ProfesorRepository;
import com.raul.block7crudvalidation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    StudentRepository studentRepository;


    @Override
    public ProfesorOutputDto addProfesor(ProfesorInputDto profesor) throws Exception {
        Optional<Persona> persona = personaRepository.findById(profesor.getPersona());
        Persona persona1 = persona.orElseThrow(() -> new EntityNotFoundException("No se ha encontrado a ninguna persona por ese id", 404));

        Profesor profe = new Profesor(profesor);
        if (persona.get().getPuesto().equals("Estudiante")) {
            throw new UnprocessableEntityException("Esta persona ya es un estudiante");
        } else if (persona.get().getPuesto().equals("Profesor")) {
            throw new UnprocessableEntityException("Esta persona ya es un profesor");
        }
        persona.orElseThrow().setPuesto("Profesor");
        profe.setPersona(persona.orElseThrow());


        return profesorRepository.save(profe).profesorOutputDto();
        //}
    }

    @Override
    public ProfesorOutputDto getProfesorById(int id) {
        Optional<Profesor> personaOptional = profesorRepository.findById(id);
        Profesor profesor = personaOptional.orElseThrow(() -> new EntityNotFoundException("No se ha encontrado a ninguna persona por ese id", 404));
        ProfesorOutputDto profesorOutputDto = profesor.profesorOutputDto();
        return profesorOutputDto;
    }

    @Override
    public List<Student> getStudentByIdProfe(int id) {

        Profesor profe = profesorRepository.findById(id).get();
        profe.getStudent().clear();
        List<Student> estudiant = studentRepository.findAll();
        for (Student estud: estudiant){
            if (estud.getProfesor().getId_profesor() == id){
                profe.getStudent().add(estud);
            }
        }

        if (profe.getStudent().size() != 0) {
            return profe.getStudent();
        }

        throw new EntityNotFoundException("No se han encontrado estudiantes con esa id de profesor",422);
    }

   /* @Override
    public List<ProfesorOutputDto> getProfesorByName(String name) {
        if (profesorRepository.findByName(name).stream().map(Profesor::profesorOutputDto).collect(Collectors.toList()).size() == 0) {
            throw new EntityNotFoundException("No se ha encontrado a ninguna persona por ese nombre", 404);
        } else {
            return profesorRepository.findByName(name).stream().map(Profesor::profesorOutputDto).collect(Collectors.toList());
        }
    }
*/

    @Override
    public List<ProfesorOutputDto> getAllProfesor(int pageNumber, int pageSize) {

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        if (profesorRepository.findAll(pageRequest).getContent().stream().map(Profesor::profesorOutputDto).toList().size() == 0) {
            throw new EntityNotFoundException("No se ha encontrado a ningun profesor", 404);
        } else {
            return profesorRepository.findAll(pageRequest).getContent().stream().map(Profesor::profesorOutputDto).toList();
        }
    }

    @Override
    public void deleteProfesorById(int id) {
        profesorRepository.findById(id).orElseThrow();
        profesorRepository.deleteById(id);
    }

    @Override
    public ProfesorOutputDto updateProfesor(ProfesorInputDto profesor, int id) {
        Optional<Profesor> existingProfesor = profesorRepository.findById(id);
        if (existingProfesor == null) {
            throw new NoSuchElementException("Persona not found with id: " + id);
        }
        Profesor updatedProfesor = new Profesor(profesor);
        updatedProfesor.setId_profesor(id);
        return profesorRepository.save(updatedProfesor).profesorOutputDto();
    }


}
