package com.raul.block13mongodb.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
public class PersonaInputDto {
    private String name;
    private long age;
    private List<String> favoriteBooks;
    private Date dateOfBirth;
}
