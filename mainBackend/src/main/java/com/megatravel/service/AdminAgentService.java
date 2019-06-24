package com.megatravel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.model.Agent;
import com.megatravel.model.User;
import com.megatravel.repository.UserRepository;

@Service
public class AdminAgentService {

	@Autowired 
	public UserRepository aaRepository;
	
	public User save(Agent newAgent) {
		if(aaRepository.findAgentByUsername(newAgent.getUsername()) != null) {
			return null;
		}

		return aaRepository.save(newAgent);
	}
	
	public void delete(User newAgent) {
		aaRepository.delete(newAgent);
	}
	
	public User findById(Long id) {
		return aaRepository.findById(id).orElse(null);
	}
	
	public List<Agent> findAllAgents() {
		return aaRepository.findAgent();
	}
	
}
