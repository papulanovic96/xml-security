package com.megatravel.service;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public interface SecurityService {
	
	public ResponseEntity<String> findLoggedInUsername();
	public UsernamePasswordAuthenticationToken login(String username, String password);

}
