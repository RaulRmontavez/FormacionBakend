package com.raul.block7crudvalidation.repository;



import com.raul.block7crudvalidation.clases.Persona;
import com.raul.block7crudvalidation.controller.dto.PersonaOutputDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonaRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<PersonaOutputDto> getCustomQuery(
            HashMap<String, Object> conditions,String ord,String order,int pageNumber,int pageSize) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> query = cb.createQuery(Persona.class);
        Root<Persona> root = query.from(Persona.class);

        List<Predicate> predicates = new ArrayList<>();

        conditions.forEach((field, value) -> {

            switch (field) {
                case "name":
                    predicates.add(cb.like(root.get(field),
                            "%" + (String) value + "%"));

                    break;
                case "surname":
                    predicates.add(cb.like(root.get(field),
                            "%" + (String) value + "%"));
                    break;
                case "usuario":
                    predicates.add(cb.like(root.get(field),
                            "%" + (String) value + "%"));
                    break;
                case "created_date":
                    predicates.add(cb.like(root.get(field),
                            "%" + (String) value + "%"));
                    break;
            }

            if (ord.equals("desc")){
                if (order.equals("none")) {
                    query.orderBy(cb.desc(root.get(field)));
                }
                else{
                    query.orderBy(cb.desc(root.get(order)));
                }
            }
            else{
                if (order.equals("none")) {
                    query.orderBy(cb.asc(root.get(field)));
                }
                else {
                    query.orderBy(cb.asc(root.get(order)));
                }
            }

        });
        query.select(root)
                .where(predicates.toArray(new Predicate[predicates.size()]));
        int firstResult = (pageNumber - 1) * pageSize;

        return entityManager
                .createQuery(query)
                .setFirstResult(firstResult)
                .setMaxResults(pageSize)
                .getResultList()
                .stream()
                .map(Persona::personaToPersonaOutputDto)
                .toList();
    }
}
