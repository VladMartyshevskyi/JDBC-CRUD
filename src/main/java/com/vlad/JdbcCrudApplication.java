package com.vlad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class JdbcCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcCrudApplication.class, args);
	}
	
}
