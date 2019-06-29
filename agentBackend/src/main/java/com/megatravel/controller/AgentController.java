package com.megatravel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager; 
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.megatravel.model.Agent;
import com.megatravel.model.Credentials;
import com.megatravel.service.UserService;

@RestController
@RequestMapping("/agent")
public class AgentController {

	@Autowired
	private RestTemplate restTemplate;


	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private UserService userservice;
	
	@RequestMapping(value="/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity login(@RequestBody Credentials credent) {
		
		Boolean logged = restTemplate.postForObject("http://login-service/login/tryToLogin", credent, Boolean.class);
		/*
		 UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(credent.getUsername(), credent.getPassword());
		 Authentication auth = authenticationManager.authenticate(authReq);
		 SecurityContext sc = SecurityContextHolder.getContext();
		 sc.setAuthentication(auth);*/
		
		if(logged)
			return new ResponseEntity(HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	

		
	
	
}
