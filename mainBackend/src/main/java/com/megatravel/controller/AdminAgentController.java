package com.megatravel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.model.Agent;
import com.megatravel.model.AgentList;
import com.megatravel.service.AdminAgentService;

@RestController
@RequestMapping("/admin-agent-creation")
public class AdminAgentController {
		
		@Autowired
		private AdminAgentService aaService;
		
		@RequestMapping(method = RequestMethod.POST, value = "/saveAgent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<String> saveAgent(@RequestBody Agent newAgent){
			Agent temp = aaService.save(newAgent);
			if(temp != null) {
				return new ResponseEntity<String>("Agent succesufully added!", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Agent with that username already exists!", HttpStatus.CONFLICT);
			}
		}
		
		@RequestMapping(value = "/findAgents", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<AgentList> findAgents() {
			List<Agent> agents = aaService.findAll();
			AgentList listAgents = new AgentList();
			listAgents.setLista(agents);
			return new ResponseEntity<AgentList>(listAgents, HttpStatus.OK);
		}
		
}