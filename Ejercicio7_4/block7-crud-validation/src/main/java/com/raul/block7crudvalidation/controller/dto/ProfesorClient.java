package com.raul.block7crudvalidation.controller.dto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8081",name = "profesorClient")
public interface ProfesorClient {
    @GetMapping("id/{id}")
    public ResponseEntity<Object> getProfesorById(@PathVariable int id);
}
