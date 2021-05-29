package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class Application {

	@Autowired
	private DatabaseService databaseService;

	public static void main(String[] args) {

		System.out.println();
	}

}
