package com.raul.block7crudvalidation.controller;

import com.raul.block7crudvalidation.controller.dto.ProfesorOutputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8081",name = "profesorClient")
public interface ProfesorClient {
    @GetMapping("profesor2/{id}")
    ProfesorOutputDto getProfesor(@PathVariable int id);
}
