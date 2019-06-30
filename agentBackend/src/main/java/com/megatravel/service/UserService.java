package com.megatravel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.megatravel.model.Agent;
import com.megatravel.model.EndUser;
import com.megatravel.model.User;
import com.megatravel.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	public EndUser findEndUser(String username) {
		return userRepository.findEndUserByUsername(username);
	}
	
	public List<EndUser> findEndUsers() {
		return userRepository.findEndUsers();
	}
	
	public void save(EndUser eu) {
		userRepository.saveAndFlush(eu);
	}
	
	
	
	public Agent getCurrentAgent() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userRepository.findAgentByUsername(principal.toString());
	}
	
}
