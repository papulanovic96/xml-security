package com.megatravel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.model.Agent;
import com.megatravel.repository.AdminAgentRepository;

@Service
public class AdminAgentService {

	@Autowired 
	public AdminAgentRepository aaRepository;
	
	public Agent save(Agent newAgent) {
		return aaRepository.save(newAgent);
	}
	
	public void delete(Agent newAgent) {
		aaRepository.delete(newAgent);
	}
	
	public List<Agent> findAll() {
		return aaRepository.findAll();
	}
	
	public Agent findById(Long id) {
		return aaRepository.findById(id).orElse(null);
	}
}
