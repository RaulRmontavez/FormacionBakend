package com.raul.block7crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentOutputDto addStudent(StudentInputDto student) {

        return studentRepository.save(new Student(student))
                .studentToStudentOutputDto();
    }
    @Override
    public StudentOutputDto getStudentById(int id) {
        return studentRepository.findById(id).orElseThrow()
                .studentToStudentOutputDto();
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.findById(id).orElseThrow();
        studentRepository.deleteById(id);
    }
    @Override
    public List<StudentOutputDto> getAllStudents(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return studentRepository.findAll(pageRequest).getContent()
                .stream()
                .map(Student::studentToStudentOutputDto).toList();
    }
    @Override
    public StudentOutputDto updateStudent(StudentInputDto student) {
        studentRepository.findById(student.getId()).orElseThrow();
        return studentRepository.save(new Student(student))
                .studentToStudentOutputDto();
    }
}
