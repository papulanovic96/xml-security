package com.megatravel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.model.EndUser;
import com.megatravel.service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {
	
	private UserService userService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String register() {
		
		return "registration test";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login() {
		
		return "login test";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout() {
		
		return "logout test";
	}
	
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String account() {
		
		return "account test";
	}
	
	@RequestMapping(value = "/inbox", method = RequestMethod.GET)
	public String inbox() {
		
		return "inbox test";
	}
	
	@RequestMapping(value = "/reservations", method = RequestMethod.GET)
	public String getReservations() {
		
		return "my reservations test";
	}
	
	@RequestMapping(value = "/createReservation", method = RequestMethod.POST)
	public String createReservation() {
		
		return "create reservation test";
	}
	

}
