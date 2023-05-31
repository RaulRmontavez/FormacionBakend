package com.raul.block13mongodb.aplication;

import com.raul.block13mongodb.domain.Persona;

import java.util.Date;
import java.util.List;

public interface PersonDAL {
    Persona savePerson(Persona person);
    List<Persona> getAllPerson();
    List<Persona> getAllPersonPaginated(
            int pageNumber, int pageSize);
    Persona findOneByName(String name);
    List<Persona> findByName(String name);
    List<Persona> findByBirthDateAfter(Date date);
    List<Persona> findByAgeRange(int lowerBound, int upperBound);
    List<Persona> findByFavoriteBooks(String favoriteBook);
    void updateMultiplePersonAge();
    Persona updateOnePerson(Persona person,String id);
    void deletePerson(Persona person);
    Persona getPersonById(String id);
}