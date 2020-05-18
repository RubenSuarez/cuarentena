package com.cuarentena.web.dto;

import com.cuarentena.web.model.User;

public class UserDTO {
	
	private Long id;
	private String email;
	private String username;
	private String name;
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.username = user.getUsername();
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
