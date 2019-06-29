package com.megatravel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.model.Agent;
import com.megatravel.model.AgentList;
import com.megatravel.model.User;
import com.megatravel.service.AdminAgentService;

@RestController
@RequestMapping("/admin-agent-creation")
public class AdminAgentController {
		
		@Autowired
		private AdminAgentService aaService;
		
		@RequestMapping(method = RequestMethod.POST, value = "/saveAgent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
			public User saveAgent(@RequestBody Agent newAgent){
			User temp = aaService.save(newAgent);
				return temp;
		}
		
		@RequestMapping(value = "/findAgents", method = RequestMethod.GET)
		public AgentList findAgents() {
			List<Agent> agents = aaService.findAllAgents();
			AgentList list = new AgentList();
			list.setLista(agents);
			return list;
		}
		
}