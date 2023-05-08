package com.raul.block7crudvalidation.clases;

import com.raul.block7crudvalidation.controller.dto.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "estudiantes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student   {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id_student;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona",nullable = false,unique = true)
    Persona persona;
    @Column(name = "horas_por_semana")
    Integer num_hours_week;
    @Column(name = "comentarios")
    String coments;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    Profesor profesor;
    @Column(name = "rama")
    String branch;
    @OneToMany
    List<Alumnos_Estudios> estudios;


    public Student(StudentInputDto student) {

        id_student = student.getId_student();
        persona = null;
        num_hours_week = student.getNum_hours_week();
        coments = student.getComents();
        profesor = null;
        branch = student.getBranch();

    }



    public StudentOutputDto StudentOutputDto() {
        return new StudentOutputDto(this.id_student,this.num_hours_week,this.coments,this.profesor,this.branch,this.estudios,this.persona.getId_persona(),this.persona.getUsuario(),this.persona.getPassword(),this.persona.getName(),this.persona.getSurname(),this.persona.getCompany_email(),this.persona.getCity(),this.persona.isActive(),this.persona.getCreated_date(),this.persona.getImagen_url(),this.persona.getTermination_date());
    }

    public StudentOutputDtoSimple StudentOutputDtoSimple() {
        return new StudentOutputDtoSimple(this.id_student,this.persona.getId_persona(),this.num_hours_week,this.coments,this.profesor,this.branch,this.estudios);
    }

}