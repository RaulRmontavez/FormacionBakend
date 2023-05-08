package com.raul.block7crudvalidation.Application;


import com.raul.block7crudvalidation.clases.Persona;
import com.raul.block7crudvalidation.clases.Profesor;
import com.raul.block7crudvalidation.clases.Student;
import com.raul.block7crudvalidation.controller.dto.*;
import com.raul.block7crudvalidation.exceptions.EntityNotFoundException;
import com.raul.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.raul.block7crudvalidation.repository.PersonaRepository;
import com.raul.block7crudvalidation.repository.ProfesorRepository;
import com.raul.block7crudvalidation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public StudentOutputDto addStudent(StudentInputDto student) throws Exception {
       /* if (Objects.isNull(profesor.getUsuario()) || profesor.getUsuario().isBlank()) {
            throw new UnprocessableEntityException("El usuario no puede estar vacio");
        } else if (persona.getUsuario().length() > 10) {
            throw new UnprocessableEntityException("Longitud de usuario no puede ser superior a 10 caracteres");
        } else if (Objects.isNull(persona.getPassword())) {
            throw new UnprocessableEntityException("La contraseña no puede estar vacio");
        } else if (Objects.isNull(persona.getName())) {
            throw new UnprocessableEntityException("El nombre no puede estar vacio");
        } else if (Objects.isNull(persona.getSurname())) {
            throw new UnprocessableEntityException("El surname no puede estar vacio");
        } else if (Objects.isNull(persona.getCompany_email())) {
            throw new UnprocessableEntityException("La compañia de email no puede estar vacia");
        } else if (Objects.isNull(persona.getCity())) {
            throw new UnprocessableEntityException("La ciudad no puede estar vacia");
        } else if (Objects.isNull(persona.isActive())) {
            throw new UnprocessableEntityException("El activo no puede estar vacio");
        } else if (Objects.isNull(persona.getCreated_date())) {
            throw new UnprocessableEntityException("La fecha de creacion no puede estar vacia");
        } else if (Objects.isNull(persona.getImagen_url())) {
            throw new UnprocessableEntityException("La url de imagen no puede estar vacio");
        } else if (Objects.isNull(persona.getTermination_date())) {
            throw new UnprocessableEntityException("La fecha de finalizacion no puede estar vacio");
        } else {*/

        Optional<Persona> id_persona = personaRepository.findById(student.getPersona());
        Persona persona = id_persona.orElseThrow(() -> new EntityNotFoundException("No se ha encontrado a ninguna persona por ese id", 404));


        Student student1 = new Student(student);
        if (id_persona.get().getPuesto().equals("Estudiante")) {
            throw new UnprocessableEntityException("Esta persona ya es un estudiante");
        } else if (id_persona.get().getPuesto().equals("Profesor")) {
            throw new UnprocessableEntityException("Esta persona ya es un profesor");
        }
        id_persona.orElseThrow().setPuesto("Estudiante");
        student1.setPersona(id_persona.orElseThrow());


        return studentRepository.save(student1).StudentOutputDto();

        //}
    }

    @Override
    public StudentOutputDto getStudentById(int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        Student student = studentOptional.orElseThrow(() -> new EntityNotFoundException("No se ha encontrado a ninguna persona por ese id", 404));
        StudentOutputDto studentOutputDto = student.StudentOutputDto();
        return studentOutputDto;
    }

    @Override
    public StudentOutputDtoSimple getStudentByIdSimple(int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        Student student = studentOptional.orElseThrow(() -> new EntityNotFoundException("No se ha encontrado a ningun estudiante por ese id", 404));
        StudentOutputDtoSimple studentOutputDto = student.StudentOutputDtoSimple();
        return studentOutputDto;
    }

  /*  @Override
    public List<StudentOutputDto> getStudentByName(String name) {
        if (studentRepository.findByName(name).stream().map(Student::StudentOutputDto).collect(Collectors.toList()).size() == 0) {
            throw new EntityNotFoundException("No se ha encontrado a ninguna persona por ese nombre", 404);
        } else {
            return studentRepository.findByName(name).stream().map(Student::StudentOutputDto).collect(Collectors.toList());
        }
    }*/


    @Override
    public List<StudentOutputDto> getAllStudent(int pageNumber, int pageSize) {

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        if (studentRepository.findAll(pageRequest).getContent().stream().map(Student::StudentOutputDto).toList().size() == 0) {
            throw new EntityNotFoundException("No se ha encontrado a ninguna persona", 404);
        } else {
            return studentRepository.findAll(pageRequest).getContent().stream().map(Student::StudentOutputDto).toList();
        }
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.findById(id).orElseThrow();
        studentRepository.deleteById(id);
    }

    @Override
    public StudentOutputDto updateStudent(StudentInputDto student, int id) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent == null) {
            throw new NoSuchElementException("Persona not found with id: " + id);
        }
        Student updatedStudent = new Student(student);
        updatedStudent.setId_student(id);
        return studentRepository.save(updatedStudent).StudentOutputDto();
    }

}
