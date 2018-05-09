package com.vlad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vlad.dao.UserDao;
import com.vlad.dao.jdbc.JdbcTemplateUserDaoImpl;

@SpringBootApplication
@Configuration
public class JdbcCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcCrudApplication.class, args);
	}
	
	@Bean
    public UserDao AuthenticationFilter() {
        return new JdbcTemplateUserDaoImpl();
    }
}
