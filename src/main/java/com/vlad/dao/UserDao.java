package com.vlad.dao;

import java.util.List;
import com.vlad.models.User;

public interface UserDao {
	void addUser(User user);
	void removeUser(Integer id);
	void updateUser(Integer id,User user);
	List<User> getAllUsers();
	User getUserById(Integer id);
	
}
