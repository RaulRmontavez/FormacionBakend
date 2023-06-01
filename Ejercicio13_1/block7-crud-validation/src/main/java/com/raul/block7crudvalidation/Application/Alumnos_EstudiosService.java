package com.raul.block7crudvalidation.Application;



import com.raul.block7crudvalidation.controller.dto.Alumnos_EstudiosInputDto;
import com.raul.block7crudvalidation.controller.dto.Alumnos_EstudiosOutputDto;
import com.raul.block7crudvalidation.controller.dto.StudentInputDto;
import com.raul.block7crudvalidation.controller.dto.StudentOutputDto;

import java.util.List;

public interface Alumnos_EstudiosService {


    Alumnos_EstudiosOutputDto addAlumnos_Estudios(Alumnos_EstudiosInputDto alumnosEstudiosInputDto) throws Exception;
    Alumnos_EstudiosOutputDto getAlumnos_EstudiosById(int id);
    List<Alumnos_EstudiosOutputDto> getAlumnos_EstudiosByName(String name);
    Iterable<Alumnos_EstudiosOutputDto> getAllAlumnos_Estudios(int pageNumber, int pageSize);
    Alumnos_EstudiosOutputDto updateAlumnos_Estudios(Alumnos_EstudiosInputDto alumnosEstudiosInputDto, int id);
    void deleteAlumnos_EstudiosById( int id);

}
