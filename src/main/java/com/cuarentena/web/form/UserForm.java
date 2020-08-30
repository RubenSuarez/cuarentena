package com.cuarentena.web.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserForm {
	@NotEmpty(message = "Debe ingresar un nombre")
	private String name;
	@NotEmpty(message = "Debe ingresar un apellido")
	private String surname;
	@NotEmpty(message = "El email es requerido.")
	@Email(message="El email debe ser valido.")
	private String email;
	@NotEmpty(message = "Debe ingresar una contraseña")
	private String password;
	@NotEmpty(message = "Debe repetir la contraseña")
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
