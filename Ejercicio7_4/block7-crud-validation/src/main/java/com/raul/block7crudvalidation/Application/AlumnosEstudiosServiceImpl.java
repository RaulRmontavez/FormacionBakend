package com.raul.block7crudvalidation.Application;


import com.raul.block7crudvalidation.clases.Alumnos_Estudios;
import com.raul.block7crudvalidation.clases.Persona;
import com.raul.block7crudvalidation.controller.dto.Alumnos_EstudiosInputDto;
import com.raul.block7crudvalidation.controller.dto.Alumnos_EstudiosOutputDto;
import com.raul.block7crudvalidation.controller.dto.PersonaInputDto;
import com.raul.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.raul.block7crudvalidation.exceptions.EntityNotFoundException;
import com.raul.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.raul.block7crudvalidation.repository.AlumnosEstudiosRepository;
import com.raul.block7crudvalidation.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlumnosEstudiosServiceImpl implements Alumnos_EstudiosService {
    @Autowired
    AlumnosEstudiosRepository alumnosEstudiosRepository;


    @Override
    public Alumnos_EstudiosOutputDto addAlumnos_Estudios(Alumnos_EstudiosInputDto alumnosEstudiosInputDto) throws Exception {
        return alumnosEstudiosRepository.save(new Alumnos_Estudios(alumnosEstudiosInputDto)).asignaturaToAlumnoOutputDto();

    }



    @Override
    public Alumnos_EstudiosOutputDto getAlumnos_EstudiosById(int id) {
        Optional<Alumnos_Estudios> AlumnosOptional = alumnosEstudiosRepository.findById(id);
        Alumnos_Estudios asignaturas = AlumnosOptional.orElseThrow(() -> new EntityNotFoundException("No se ha encontrado ninguna asignatura por ese id", 404));
        Alumnos_EstudiosOutputDto alumnoOutputDto = asignaturas.asignaturaToAlumnoOutputDto();
        return alumnoOutputDto;

    }

    @Override
    public List<Alumnos_EstudiosOutputDto> getAlumnos_EstudiosByName(String name) {
        return null;
    }

    @Override
    public Iterable<Alumnos_EstudiosOutputDto> getAllAlumnos_Estudios(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Alumnos_EstudiosOutputDto updateAlumnos_Estudios(Alumnos_EstudiosInputDto alumnosEstudiosInputDto, int id) {
        return null;
    }

    @Override
    public void deleteAlumnos_EstudiosById(int id) {

    }
}
