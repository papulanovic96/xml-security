package com.megatravel.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public EndUser findEndUserByUsername(String username) {
		return userRepository.findEndUserByUsername(username);
	}
	
	public Agent findAgentByUsername(String username) {
		return userRepository.findAgentByUsername(username);
	}
	
	public List<EndUser> findEndUsers() {
		return userRepository.findEndUsers();
	}

	@Transactional
	public void save(User eu) {
		userRepository.saveAndFlush(eu);
	}
	
}
