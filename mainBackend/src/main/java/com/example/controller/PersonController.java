package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.UPerson;
import com.example.service.PersonService;

@Controller
@RequestMapping("/accounts")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> get() {

		List<UPerson> accounts =  personService.findAll();
		
		if (accounts.size() > 0)
			return new ResponseEntity<>("+1 users", HttpStatus.OK);
		else
			return new ResponseEntity<>("0 users", HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> create(@RequestBody UPerson request) {
		
		return new ResponseEntity<>("Account successfully created!", HttpStatus.OK);
	}
	
	

}
