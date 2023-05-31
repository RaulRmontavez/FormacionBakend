package com.raul.block13mongodb.aplication;

import com.raul.block13mongodb.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class PersonDALImpl implements PersonDAL {


    private final MongoTemplate mongoTemplate;

    @Autowired
    public PersonDALImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public Persona savePerson(Persona person) {
        mongoTemplate.save(person);
        return person;
    }

    @Override
    public Persona getPersonById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Persona.class);
    }


    @Override
    public List<Persona> getAllPerson() {
        return mongoTemplate.findAll(Persona.class);
    }

    @Override
    public List<Persona> getAllPersonPaginated(int pageNumber, int pageSize) {
        Query query = new Query();
        query.skip(pageNumber * pageSize);
        query.limit(pageSize);
        return mongoTemplate.find(query, Persona.class);
    }

    @Override
    public Persona findOneByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, Persona.class);
    }

    @Override
    public List<Persona> findByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.find(query, Persona.class);
    }

    @Override
    public List<Persona> findByBirthDateAfter(Date date) {
        Query query = new Query();
        query.addCriteria(Criteria.where("dateOfBirth").gt(date));
        return mongoTemplate.find(query, Persona.class);
    }

    @Override
    public List<Persona> findByAgeRange(int lowerBound, int upperBound) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gt(lowerBound)
                .andOperator(Criteria.where("age").lt(upperBound)));
        return mongoTemplate.find(query, Persona.class);
    }
    @Override
    public List<Persona> findByFavoriteBooks(String favoriteBook) {
        Query query = new Query();
        query.addCriteria(Criteria.where("favoriteBooks").in(favoriteBook));
        return mongoTemplate.find(query, Persona.class);
    }

    @Override
    public void updateMultiplePersonAge() {
        Query query = new Query();
        Update update = new Update().inc("age", 1);
        mongoTemplate.findAndModify(query, update, Persona.class);;
    }
    @Override
    public Persona updateOnePerson(Persona persona) {
        mongoTemplate.save(persona);
        return persona;
    }

    @Override
    public void deletePerson(Persona person) {
        mongoTemplate.remove(person);
    }
}
