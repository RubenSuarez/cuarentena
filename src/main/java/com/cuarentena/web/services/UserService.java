package com.cuarentena.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuarentena.web.dao.UserDAO;
import com.cuarentena.web.dto.UserDTO;
import com.cuarentena.web.model.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	public UserDTO getUser() {
		User user = userDAO.findById(1L).orElse(new User("no funca", "no funca", "no funca", "no funca"));
		UserDTO userDTO = new UserDTO(user);
		return userDTO;
	}
}
