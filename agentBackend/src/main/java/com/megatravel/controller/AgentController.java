package com.megatravel.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.megatravel.model.Credentials;
import com.megatravel.service.UserService;

@RestController
@RequestMapping("/agent")
public class AgentController {

	@Autowired
	private RestTemplate restTemplate;

	
	@Autowired
	private UserService userservice;
	
	@RequestMapping(value="/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	public boolean login(@RequestBody Credentials credent) {
				
		Boolean logged = restTemplate.postForObject("http://login-service/login/tryToLogin", credent, Boolean.class);
	
		return logged;
	}
	
	@RequestMapping(value="/syncUsers", method = RequestMethod.GET)
	public ResponseEntity syncUsers() {
		
		
		return new ResponseEntity(HttpStatus.OK);
	}
		
	
	
}
