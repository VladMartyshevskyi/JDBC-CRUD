package com.vlad.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vlad.models.Role;
import com.vlad.models.User;

public class UserMapper implements RowMapper {

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
