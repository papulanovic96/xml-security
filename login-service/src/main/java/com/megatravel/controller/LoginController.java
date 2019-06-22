package com.megatravel.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.model.EndUser;
import com.megatravel.service.MainService;
import com.megatravel.service.SecurityService;


@RestController
@RequestMapping(value = "login")
public class LoginController {
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private MainService mainService;
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void login(@RequestBody EndUser user) {
		
		if (securityService.login(user.getUsername(), user.getPassword()) != null) {
			mainService.confirmLogin(securityService.login(user.getUsername(), user.getPassword()));
		}
		
		
	}
	
	@RequestMapping(value = "/findLogged", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String findLogged() {
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
