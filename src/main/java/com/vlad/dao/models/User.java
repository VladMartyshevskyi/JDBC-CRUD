package com.vlad.dao.models;

public class User {

	private Integer id;
	private String name;
	private String lastName;
	private Role role;

	public User() {
	}

	public User(Integer id, String name, String lastName, Role role) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
