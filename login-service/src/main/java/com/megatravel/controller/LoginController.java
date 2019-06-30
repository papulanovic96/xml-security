package com.megatravel.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.dto.UserDTO;
import com.megatravel.service.MicroService;
import com.megatravel.service.SecurityService;


@RestController
@RequestMapping(value = "/")
public class LoginController {
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private MicroService microService;
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> login(@RequestBody UserDTO user) {
		
		if (securityService.login(user.getUsername(), user.getPassword()) != null) {
			microService.confirmLogin(user.getUsername());
			return ResponseEntity.ok().build();
		} else 
			return new ResponseEntity<String>("Incorrect username and password!", HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/findLogged", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> findLogged() {
		return securityService.findLoggedInUsername();
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String test() {
		return "test";
	}
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String test1() {
		return "test1";
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String test2() {
		return "test2";
	}
	@RequestMapping(value = "/test3", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String test3() {
		return "test3";
	}
	
	

}