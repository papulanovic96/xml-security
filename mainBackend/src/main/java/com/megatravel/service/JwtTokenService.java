package com.megatravel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.model.JwtToken;
import com.megatravel.repository.JwtTokenRepository;

@Service
public class JwtTokenService {
	
	@Autowired
	private JwtTokenRepository jwtTokenRepository;
	
	public void save(JwtToken token) {
		jwtTokenRepository.save(token);
	}
	
	public JwtToken findToken(String token) { 
		return jwtTokenRepository.findByToken(token);
	}

	public void remove(JwtToken token) {
		jwtTokenRepository.delete(token);
	}

}
