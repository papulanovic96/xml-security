package com.megatravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.model.User;
import com.megatravel.service.AEndUserService;

@RestController
@RequestMapping("/end-user-action")
public class AEndUserController {
	
	@Autowired
	private AEndUserService euService;
	
	@RequestMapping(value = "/delete/{username}", method = RequestMethod.DELETE)
	public ResponseEntity<String> requestMethodName(@PathVariable String username) {
		User newUser = euService.findByUsername(username);
		if(newUser != null) {
			return new ResponseEntity<String>(newUser.getUsername() + " deleted!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("User with username: >" + username + "< not found!", HttpStatus.NOT_FOUND);
		}
	}


}
