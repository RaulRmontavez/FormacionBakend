package com.raul.block7crudvalidation.clases;

import com.raul.block7crudvalidation.Application.PersonaService;
import com.raul.block7crudvalidation.controller.dto.*;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profesor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profesor   {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id_profesor;

    @OneToOne
    @JoinColumn(name = "id_persona")
    Persona persona;

    @Column(name = "comentarios")
    String coments;

    @Column(name = "rama",nullable = true)
    String branch;

    @JoinColumn(name = "id_student")
    @ManyToOne
    Student student;

    public Profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public Profesor(ProfesorInputDto profesor) {

        id_profesor = profesor.getId_profesor();
        coments = profesor.getComents();
        branch = profesor.getBranch();
    }

    public ProfesorOutputDto profesorOutputDto() {
       PersonaOutputDto person = this.persona.personaToPersonaOutputDto();

        return new ProfesorOutputDto(this.id_profesor, person, this.coments, this.branch);
    }

    public ProfesorOutputDto profesorOutputDtoSimple() {
        PersonaOutputDto person = this.persona.personaToPersonaOutputDto();
        return new ProfesorOutputDto(this.id_profesor, person, this.coments, this.branch);
    }
}