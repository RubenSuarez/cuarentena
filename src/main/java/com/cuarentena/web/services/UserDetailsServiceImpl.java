package com.cuarentena.web.services;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cuarentena.web.dao.UserDAO;
import com.cuarentena.web.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDAO.findByEmail(username); 
		
		if (user == null) throw new UsernameNotFoundException(username);
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), 
				(user.getPassword() == null) ? "" : user.getPassword(),
				true, true, true, true, Collections.singletonList(user.getRole()));
        
	}
	
}
