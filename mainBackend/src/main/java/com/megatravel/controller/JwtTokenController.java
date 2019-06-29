package com.megatravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.model.JwtToken;
import com.megatravel.service.JwtTokenService;

@RestController
@RequestMapping(value = "/token")
public class JwtTokenController {
	
	@Autowired
	private JwtTokenService jwtTokenService;
	
	@RequestMapping(value = "/find", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean findByToken(@RequestBody String token) {
		if (jwtTokenService.findToken(token) == null)
			return false;
		else 
			return true;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody JwtToken token) {
		jwtTokenService.save(token);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@RequestBody JwtToken token) {
		jwtTokenService.remove(token);
	}
}
