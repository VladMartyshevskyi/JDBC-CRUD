package com.vlad.dao.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.vlad.dao.interfaces.UserDao;
import com.vlad.dao.models.Role;
import com.vlad.dao.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDaoImpl implements UserDao {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String QUERY_INSERT = "INSERT INTO Users (name, lastName, role) VALUES (?,?,?)";
	private static final String QUERY_UPDATE = "UPDATE Users SET name = ?, lastName = ?, role = ? WHERE id = ?";
	private static final String QUERY_SELECT_ALL = "SELECT * FROM Users";
	private static final String QUERY_SELECT_BY_ID = "SELECT * FROM Users WHERE id = ?";
	private static final String QUERY_DELETE_BY_ID = "DELETE FROM Users WHERE id = ?";

	@Override
	public void add(User user) {
		jdbcTemplate.update(QUERY_INSERT, user.getName(), user.getLastName(), user.getRole().name());
	}

	@Override
	public void remove(Integer id) {
		jdbcTemplate.update(QUERY_DELETE_BY_ID, id);
	}

	@Override
	public void update(User user) {
		jdbcTemplate.update(QUERY_UPDATE, user.getName(), user.getLastName(), user.getRole().name(), user.getId());
	}

	@Override
	public List<User> getAll() {
		List<User> users = jdbcTemplate.query(QUERY_SELECT_ALL, new UserMapper());
		return users;
	}

	@Override
	public User getById(Integer id) {
		User user = (User) jdbcTemplate.queryForObject(QUERY_SELECT_BY_ID, new Object[] { id }, new UserMapper());
		return user;
	}

	private class UserMapper implements RowMapper {

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setLastName(rs.getString("lastName"));
			user.setRole(Role.valueOf(rs.getString("role")));
			return user;
		}

	}

}
