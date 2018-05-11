package com.vlad.dao.interfaces;

import java.util.List;
import javax.sql.DataSource;
import com.vlad.dao.models.User;

public interface UserDao {
	void add(User user);
	void remove(Integer id);
	void update(User user);
	List<User> getAll();
	User getById(Integer id);
}
