package com.raul.block13mongodb.Dto;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PersonaOutputDto {

    private UUID personId;
    private String name;
    private long age;
    private List<String> favoriteBooks;
    private Date dateOfBirth;
}
