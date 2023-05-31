package com.raul.block13mongodb.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@Data
public class PersonaOutputDto {

    private String personId;
    private String name;
    private long age;
    private List<String> favoriteBooks;
    private Date dateOfBirth;
}
