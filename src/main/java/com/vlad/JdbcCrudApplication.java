package com.vlad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vlad.dao.interfaces.UserDao;
import com.vlad.dao.services.UserDaoImpl;

@SpringBootApplication
@Configuration
public class JdbcCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcCrudApplication.class, args);
	}

	@Bean
	public UserDao getUserDaoBean() {
		return new UserDaoImpl();
	}
}
