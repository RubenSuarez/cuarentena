package com.cuarentena.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cuarentena.web.services.ExampleServiceRest;

@RestController
@RequestMapping(value = "/example")
public class ExampleEndPoint {

	@Autowired
	private ExampleServiceRest exapleServiceRest;
	
	@RequestMapping(value = "/sarasa", method = RequestMethod.GET)
	public ResponseEntity<?> sarasa(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(exapleServiceRest.exampleRest()); 
		} catch(Exception e) {
			return null;
		}
	}
}
