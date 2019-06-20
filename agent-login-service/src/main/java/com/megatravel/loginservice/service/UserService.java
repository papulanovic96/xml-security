package com.megatravel.loginservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.megatravel.loginservice.models.Agent;
import com.megatravel.loginservice.models.User;
import com.megatravel.loginservice.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getAll(){
		return this.userRepository.findAll();
	}
	
	public Agent findByUsername(String username) {
		return this.userRepository.findAgentByUsername(username);
	}
	public List<Agent> findAgents() {
		return userRepository.findAgents();
	}
	
	public void save(Agent agent) {
		userRepository.saveAndFlush(agent);
	}
	

}
