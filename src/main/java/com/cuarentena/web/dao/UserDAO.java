package com.cuarentena.web.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cuarentena.web.model.User;

public interface UserDAO extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
}
