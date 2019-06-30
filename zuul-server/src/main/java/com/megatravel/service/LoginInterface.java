package com.megatravel.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.megatravel.model.EndUser;

@Service
public interface LoginInterface {
	 String login(String username, String password);
	 
	 ResponseEntity<String>  saveUser(EndUser user);

	 boolean logout(String token);

	 Boolean isValidToken(String token);

	 String createNewToken(String token);
	 
	 ResponseEntity<String> findLoggedInUsername();
}
 