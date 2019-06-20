package com.megatravel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.core.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.model.EndUser;
import com.megatravel.security.SecurityServiceImplementation;
import com.megatravel.service.MainService;
import com.megatravel.service.SecurityService;


@RestController
@RequestMapping(value = "login")
public class LoginController {
	
	@Autowired
	private MainService mainService;
	
	@Autowired
	private SecurityServiceImplementation securityService;
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public void autoLogin(@RequestBody EndUser user) {
		securityService.autoLogin(user.getUsername(), user.getPassword());
	}
	
	@RequestMapping(value = "findLogged", method = RequestMethod.GET)
	public String findLogged() {
		return securityService.findLoggedInUsername();
	}
	
	
	
	

}
