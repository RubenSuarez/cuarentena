package com.cuarentena.web.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuarentena.web.model.User;

public interface UserDAO extends JpaRepository<User, Long>{
	
//	Optional<User> findById(Long id);

}
