package com.raul.block7crudvalidation.Application;



import com.raul.block7crudvalidation.clases.Profesor;
import com.raul.block7crudvalidation.clases.Student;
import com.raul.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.raul.block7crudvalidation.controller.dto.ProfesorInputDto;
import com.raul.block7crudvalidation.controller.dto.ProfesorOutputDto;
import com.raul.block7crudvalidation.controller.dto.StudentInputDto;

import java.util.List;

public interface ProfesorService {


    ProfesorOutputDto addProfesor(ProfesorInputDto profesor) throws Exception;
    ProfesorOutputDto getProfesorById(int id);
    //List<ProfesorOutputDto> getProfesorByName(String name);
    Iterable<ProfesorOutputDto> getAllProfesor(int pageNumber, int pageSize);
    ProfesorOutputDto updateProfesor(ProfesorInputDto profesor, int id);
    void deleteProfesorById( int id);
    Profesor getProfesorByIdPersona(int id);

    List<Student> getStudentByIdProfe(int id);


}
