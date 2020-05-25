package com.cuarentena.web.dto;

import com.cuarentena.web.model.User;

public class UserDTO {
	
	private Long id;
	private String email;
	private String surname;
	private String name;
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.surname = user.getSurname();
		this.name = user.getName();
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
