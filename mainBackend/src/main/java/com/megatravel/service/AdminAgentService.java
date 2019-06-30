package com.megatravel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.converter.AgentConverter;
import com.megatravel.dto.AgentDTO;
import com.megatravel.model.Agent;
import com.megatravel.model.User;
import com.megatravel.repository.AddressRepository;
import com.megatravel.repository.UserRepository;

@Service
public class AdminAgentService {

	@Autowired 
	private UserRepository aaRepository;
	
	public User save(AgentDTO newAgent) {
		if(aaRepository.findAgentByUsername(newAgent.getUsername()) != null) {
			return null;
		}
		Agent newAgentic = AgentConverter.toEntity(newAgent);		
		return aaRepository.save(newAgentic);
	}
	
	public void delete(User newAgent) {
		aaRepository.delete(newAgent);
	}
	
	public User findById(Long id) {
		return aaRepository.findById(id).orElse(null);
	}
	
	public List<AgentDTO> findAllAgents() {
		List<Agent> agenti = aaRepository.findAgent();
		List<AgentDTO> agents = AgentConverter.fromEntityList(agenti, e -> AgentConverter.fromEntity(e));
		return agents;
	}
	
}
