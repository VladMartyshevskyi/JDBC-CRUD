package com.vlad.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vlad.dao.interfaces.UserDao;
import com.vlad.dao.models.User;

@RestController
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public List<User> allUsers() {
		return userDao.getAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
	public User getUser(@PathVariable Integer id) {
		return userDao.getById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public void addUser(@RequestBody User user) {
		userDao.add(user);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/")
	public void updateUser(@RequestBody User user) {
		userDao.update(user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userDao.remove(id);
	}
}
