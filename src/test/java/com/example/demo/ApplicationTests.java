package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private DatabaseService databaseService;

	@Test
	void contextLoads() {
		databaseService
				.findEntity("users", "users", "name", "Indian Oven");



	}

}
