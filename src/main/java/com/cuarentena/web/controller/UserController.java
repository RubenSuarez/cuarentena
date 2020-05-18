package com.cuarentena.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cuarentena.web.services.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value= {"", "/"} , method = RequestMethod.GET)
	public String user(Model model) {
		model.addAttribute("user", userService.getUser());
		return "welcome";
	}
	
}
