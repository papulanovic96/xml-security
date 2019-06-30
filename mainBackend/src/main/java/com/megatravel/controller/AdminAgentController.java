package com.megatravel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.dto.AgentDTO;
import com.megatravel.model.User;
import com.megatravel.service.AddressService;
import com.megatravel.service.AdminAgentService;

@RestController
@RequestMapping("/admin-agent-creation")
public class AdminAgentController {
		
		@Autowired
		private AdminAgentService aaService;
		
		@Autowired
		private AddressService aService;
		
		@RequestMapping(method = RequestMethod.POST, value = "/saveAgent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
			public User saveAgent(@RequestBody AgentDTO newAgent){
			//aService.save(newAgent.getAddress());
			User temp = aaService.save(newAgent);
				return temp;
		}
		
		@RequestMapping(value = "/findAgents", method = RequestMethod.GET)
		public List<AgentDTO> findAgents() {
			return aaService.findAllAgents();
		}
		
}