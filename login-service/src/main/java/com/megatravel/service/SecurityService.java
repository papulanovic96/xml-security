package com.megatravel.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface SecurityService {
	
	public ResponseEntity<String> findLoggedInUsername();
	public UsernamePasswordAuthenticationToken login(String username, String password);

}
