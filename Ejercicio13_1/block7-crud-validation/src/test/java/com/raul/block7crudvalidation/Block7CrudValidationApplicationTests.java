package com.raul.block7crudvalidation;

import com.raul.block7crudvalidation.Application.PersonaService;
import com.raul.block7crudvalidation.clases.Persona;
import com.raul.block7crudvalidation.repository.PersonaRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class Block7CrudValidationApplicationTests {


	@Test
	void test1() {
		System.out.println("Ejecutando test");
	}


	@Test
	@DisplayName("Insert direction OK")
	void insertDirectionOk(){
		Assertions.assertTrue(true);
	}



}
