package com.vlad.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.vlad.dao.interfaces.BookDao;
import com.vlad.dao.interfaces.UserDao;
import com.vlad.dao.services.BookDaoImpl;
import com.vlad.dao.services.UserDaoImpl;

@Configuration
public class DBConfig {

	@Autowired
	private Environment env;

	@Bean(name = "firstDB")
	public DataSource firstDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.first-datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.first-datasource.url"));
		dataSource.setUsername(env.getProperty("spring.first-datasource.username"));
		dataSource.setPassword(env.getProperty("spring.first-datasource.password"));
		return dataSource;
	}

	@Bean(name = "secondDB")
	public DataSource secondDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.second-datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.second-datasource.url"));
		dataSource.setUsername(env.getProperty("spring.second-datasource.username"));
		dataSource.setPassword(env.getProperty("spring.second-datasource.password"));
		return dataSource;
	}

	@Bean(name = "firstDBTemplate")
	public JdbcTemplate jdbcTemplate(@Qualifier("firstDB") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean(name = "secondDBTemplate")
	public JdbcTemplate postgresJdbcTemplate(@Qualifier("secondDB") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public UserDao getUserDaoBean() {
		return new UserDaoImpl();
	}

	@Bean
	public BookDao getBookDaoBean() {
		return new BookDaoImpl();
	}
}
