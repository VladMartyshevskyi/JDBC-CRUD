package com.vlad.dao.jdbc;

import java.util.List;

import javax.sql.DataSource;

import com.vlad.dao.UserDao;
import com.vlad.models.User;
import com.vlad.utils.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
public class JdbcTemplateUserDaoImpl implements UserDao {
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void addUser(User user) {
		String SQL = "INSERT INTO Users (name, lastName, role) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, user.getName(), user.getLastName(), user.getRole().name());
		
	}

	@Override
	public void removeUser(Integer id) {
		String SQL = "DELETE FROM Users WHERE id = ?";
		jdbcTemplate.update(SQL, id);
	}

	@Override
	public void updateUser(Integer id, User user) {
		String SQL = "UPDATE Users SET name = ?, lastName = ?, role = ? WHERE id = ?";
		 jdbcTemplate.update(SQL, user.getName(), user.getLastName(), user.getRole().name(), id);
	}

	@Override
	public List<User> getAllUsers() {
		 String SQL = "SELECT * FROM Users";
	     List<User> users = jdbcTemplate.query(SQL, new UserMapper());
	     return users;
	}

	@Override
	public User getUserById(Integer id) {
		String SQL = "SELECT * FROM Users WHERE id = ?";
        User user = (User) jdbcTemplate.queryForObject(SQL, new Object[]{id}, new UserMapper());
        return user;
	}
	

}
