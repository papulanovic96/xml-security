package com.megatravel.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.megatravel.model.EndUser;
import com.megatravel.service.RegistrationService;


@RestController
@RequestMapping(value = "/registration")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	public RegistrationController(RegistrationService registrationService) {
		this.registrationService = registrationService;
		
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> register(@RequestBody EndUser user) {
	
		EndUser exist = registrationService.exist(user);
		
		if (exist == null) { 
			
			EndUser newUser = new EndUser();
			
			newUser.setUsername(user.getUsername());
			newUser.setPassword(user.getPassword());
			newUser.setLastName(user.getLastName());
			newUser.setFirstName(user.getFirstName());
			newUser.setEmail(user.getEmail());
			
			registrationService.saveEndUser(newUser);
			
			return ResponseEntity.ok("Account successfully created!");
		} else {
			return ResponseEntity.badRequest().body("Username already exists!");
		} 
		
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String get() {
		
		return  registrationService.getTest();
	}
	
	@RequestMapping(value = "/end", method = RequestMethod.GET)
	public List<EndUser> end() {
		
		return  registrationService.getEndUsers();
	}
	


}
