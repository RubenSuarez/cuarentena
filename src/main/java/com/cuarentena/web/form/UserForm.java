package com.cuarentena.web.form;

public class UserForm {
	
	private String name;
	private String surname;
	private String email;
	private String password;
	private String repeatPassword;
	
	public UserForm() {}
	
	public UserForm(String name, String surname, String email, String password, String repeatPassword) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.repeatPassword = repeatPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
}
