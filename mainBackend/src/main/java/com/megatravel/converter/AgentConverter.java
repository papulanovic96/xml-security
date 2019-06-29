package com.megatravel.converter;

import com.megatravel.dto.AgentDTO;
import com.megatravel.model.Agent;

public class AgentConverter extends AbstractConverter{

	public static AgentDTO fromEntity(Agent e) {
		AgentDTO newUserDTO = new AgentDTO();
		newUserDTO.setId(e.getId());
		newUserDTO.setUsername(e.getUsername());
		newUserDTO.setEmail(e.getEmail());
		newUserDTO.setFirstName(e.getFirstName());
		newUserDTO.setLastName(e.getLastName());
		newUserDTO.setPassword(e.getPassword());
		newUserDTO.setBrn(e.getBrn());
		newUserDTO.setAddress(e.getAddress());
		return newUserDTO;
	}
	
	public static Agent toEntity(AgentDTO d) {
		Agent agent = new Agent();
		agent.setId(d.getId());
		agent.setUsername(d.getUsername());
		agent.setEmail(d.getEmail());
		agent.setFirstName(d.getFirstName());
		agent.setLastName(d.getLastName());
		agent.setPassword(d.getPassword());
		agent.setBrn(d.getBrn());
		agent.setAddress(d.getAddress());
		return agent;
	}
}
