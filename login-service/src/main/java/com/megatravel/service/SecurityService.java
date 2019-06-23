package com.megatravel.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface SecurityService {
	
	public String findLoggedInUsername();
	public UsernamePasswordAuthenticationToken login(String username, String password);

}
