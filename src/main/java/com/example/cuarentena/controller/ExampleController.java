package com.example.cuarentena.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="/")
public class ExampleController {
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String example() {
		return "HOLA MUNDO";
	}
	
}
