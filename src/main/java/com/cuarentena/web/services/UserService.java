package com.cuarentena.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cuarentena.web.dao.UserDAO;
import com.cuarentena.web.dto.UserDTO;
import com.cuarentena.web.form.UserForm;
import com.cuarentena.web.model.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();	
	
	public UserDTO getUser() {
		User user = userDAO.findById(1L).orElse(new User("no funca", "no funca","no funca", "no funca", "no funca"));
//		User user = userDAO.getOne(1L);
		UserDTO userDTO = new UserDTO(user);
		return userDTO;
	}
	
	//TODO: ARMAR BIEN ESTE METODO CON EXCEPCIONES
	public boolean create(UserForm userForm) {
		if(!userForm.getPassword().equals(userForm.getRepeatPassword())){
			return false;
		}
		
		User user = userDAO.findByEmail(userForm.getEmail());
		
		if(user != null) {
			return false;
		}
		String password = bCryptPasswordEncoder.encode(userForm.getPassword());
		userDAO.save(new User(userForm.getName(), userForm.getEmail(), userForm.getSurname(), userForm.getEmail(), password));
		
		return true;
	}
	
	public String validarPass(UserForm user) {
		String email = user.getEmail();
		String pass =  bCryptPasswordEncoder.encode(user.getPassword());
		User usuarioRegistrado = userDAO.findByEmail(email);
		if(usuarioRegistrado != null) {
			//el usuario existe 
			if(usuarioRegistrado.getPassword() == pass) {
				return "acceso permitido";
			}
			else {
				return "password invalido";
			}
		}
		return "email invalido";
	}
}
