package com.cuarentena.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cuarentena.web.form.UserForm;
import com.cuarentena.web.model.User;
import com.cuarentena.web.services.UserService;

@Controller
@RequestMapping(value= {"/", ""})
public class LoginController {
	
	@Autowired
	private UserService userService; 
	
	@RequestMapping(value= {"login", "login/"}, method = RequestMethod.GET)
	public String login(Model model, @ModelAttribute User user) {
		return "login";
	}
	
	@RequestMapping(value= {"login", "login/"}, method = RequestMethod.POST)
	public String login2(Model model, @ModelAttribute UserForm user) {
		String estado = userService.validarPass(user);
		String[] estados = {"acceso permitido","password invalido","email invalido"};
		if(estado == estados[0]) {
			return "welcome";
		}
		else if(estado == estados[1]) {
			model.addAttribute("texto","contraseña incorrecta");
			return "login";
		}
		else {
			model.addAttribute("texto","el email ingresado no se encuentra registrado");
			return "login";
		}
	}
	
	@RequestMapping(value= {"sign-up", "sign-up/"}, method = RequestMethod.GET)
	public String signUp(Model model) {
		model.addAttribute("user", new UserForm());
		return "sign-up";
	}
	
	@RequestMapping(value= "addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") UserForm user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("user", new UserForm());
			return "sign-up";
		}
		
		if(!userService.create(user)) {
			//TODO: ARMAR BIEN ESTA PARTE CON EXCEPCIONES
			return "sign-up";
		}
		
		return "welcome";
	}
	
}
