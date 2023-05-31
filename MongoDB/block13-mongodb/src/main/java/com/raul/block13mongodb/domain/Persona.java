package com.raul.block13mongodb.domain;

import com.raul.block13mongodb.Dto.PersonaInputDto;
import com.raul.block13mongodb.Dto.PersonaOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "person")
public class Persona {
    @Id
    private String personId;
    private String name;
    private long age;
    private List<String> favoriteBooks;
    private Date dateOfBirth;



    public Persona(String name, List<String> favoriteBooks,long age, Date dateOfBirth) {
        this.personId = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.favoriteBooks = favoriteBooks;
        this.dateOfBirth = dateOfBirth;
    }

    public Persona(PersonaInputDto persona) {
        this.personId = UUID.randomUUID().toString();
        this.name = persona.getName();
        this.age = persona.getAge();
        this.favoriteBooks = persona.getFavoriteBooks();
        this.dateOfBirth = persona.getDateOfBirth();
    }

    public PersonaOutputDto personaToPersonaOutputDto() {
        return new PersonaOutputDto(this.personId, this.name, this.age, this.favoriteBooks, this.dateOfBirth);
    }
}
