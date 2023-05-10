package com.raul.block7crudvalidation.Application;


import com.raul.block7crudvalidation.clases.Alumnos_Estudios;
import com.raul.block7crudvalidation.clases.Persona;
import com.raul.block7crudvalidation.clases.Profesor;
import com.raul.block7crudvalidation.clases.Student;
import com.raul.block7crudvalidation.controller.dto.*;
import com.raul.block7crudvalidation.exceptions.EntityNotFoundException;
import com.raul.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.raul.block7crudvalidation.repository.AlumnosEstudiosRepository;
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

    @Autowired
    ProfesorService profesorService;

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    AlumnosEstudiosRepository alumnosEstudiosRepository;

    @Override
    public StudentOutputDto addStudent(StudentInputDto studentDto) throws Exception {

        Persona id_persona = personaRepository.findById(studentDto.getPersona()).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado a ninguna persona por ese id", 404));


        Student student1 = new Student(studentDto);
        if (id_persona.getPuesto().equals("Estudiante")) {
            throw new UnprocessableEntityException("Esta persona ya es un estudiante");
        } else if (id_persona.getPuesto().equals("Profesor")) {
            throw new UnprocessableEntityException("Esta persona ya es un profesor");
        }
        id_persona.setPuesto("Estudiante");
        student1.setPersona(id_persona);
        student1.setProfesor(null);

        if (studentDto.getProfesor() != null) {
            Optional<Profesor> id_profesor = profesorRepository.findById(studentDto.getProfesor());

            if (id_profesor.get().getId_profesor() != null) {
                student1.setProfesor(id_profesor.orElseThrow());
                profesorService.getStudentByIdProfe(studentDto.getProfesor());
            }
        }

        return studentRepository.save(student1).StudentOutputDto();


    }


    @Override
    public StudentOutputDto addAsignatura(int id_asignatura, int id_student) throws Exception {

        Student student = studentRepository.findById(id_student).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado a ninguna persona por ese id", 404));
        Alumnos_Estudios alumnosEstudios = alumnosEstudiosRepository.findById(id_asignatura).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado a ninguna asignatura por ese id", 404));


        if (student.getEstudios().contains(alumnosEstudios)) {
            throw new UnprocessableEntityException("Este estudiante ya tiene esta asignatura");
        }
        alumnosEstudios.getStudent().add(student);
        student.getEstudios().add(alumnosEstudios);
        alumnosEstudiosRepository.save(alumnosEstudios);
        return studentRepository.save(student).StudentOutputDto();
    }


    @Override
    public StudentOutputDto addAsignaturas(List<Integer> id_asignatura, int id_student) throws Exception {

        Student student = studentRepository.findById(id_student).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado a ninguna persona por ese id", 404));

        Alumnos_Estudios asig = null;
        for (int alum : id_asignatura) {
            asig = alumnosEstudiosRepository.findById(alum).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado a ninguna asignatura por ese id", 404));
            if (student.getEstudios().contains(asig.getId_study())){
                System.out.println("Asignatura duplicada no añadida");
            }
            else{
                asig.getStudent().add(student);
                student.getEstudios().add(asig);

            }
        }
        alumnosEstudiosRepository.save(asig);
        return studentRepository.save(student).StudentOutputDto();
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
        Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado a ningun estudiante por ese id", 404));
        Persona id_persona = personaRepository.findById(student.getPersona().getId_persona()).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado a ninguna persona por ese id", 404));
        id_persona.setPuesto("");

        personaRepository.save(id_persona);
        studentRepository.deleteById(id);
    }

    @Override
    public StudentOutputDto updateStudent(StudentInputDto student, int id) {
        Optional<Student> existingStudent = studentRepository.findById(id);

        Optional<Persona> id_persona = personaRepository.findById(student.getPersona());
        Persona persona = id_persona.orElseThrow(() -> new EntityNotFoundException("No se ha encontrado a ninguna persona por ese id", 404));

        Optional<Profesor> id_profesor = profesorRepository.findById(student.getProfesor());

        if (existingStudent == null) {
            throw new NoSuchElementException("Estudiante not found with id: " + id);
        }
        Student updatedStudent = new Student(student);
        id_persona.orElseThrow().setPuesto("Estudiante");
        updatedStudent.setPersona(id_persona.orElseThrow());
        updatedStudent.setProfesor(id_profesor.orElseThrow());

        updatedStudent.setStudent(updatedStudent);

        if (updatedStudent.getProfesor() != null) {
            profesorService.getStudentByIdProfe(student.getProfesor());
        }

        return studentRepository.save(updatedStudent).StudentOutputDto();
    }

}
