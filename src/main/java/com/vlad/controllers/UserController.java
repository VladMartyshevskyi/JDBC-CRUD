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

import com.vlad.dao.UserDao;
import com.vlad.models.User;

@RestController
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
    public List allUsers(){
        return userDao.getAllUsers();
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public User getUser(@PathVariable Integer id){
        return userDao.getUserById(id);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody User user){
        userDao.addUser(user);
    }
	
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody User user){
        userDao.updateUser(id, user);
    }
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUser(@PathVariable Integer id){
        userDao.removeUser(id);
    }
}
