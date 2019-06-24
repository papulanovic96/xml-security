package com.microagent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microagent.model.AgentList;
import com.microagent.model.User;

@RestController
@RequestMapping("/getAgents")
public class GetAgentsController {

	@Autowired
	private RestTemplate restTemplate;
	private String findAgentURL = "http://localhost:8000/admin-agent-creation/findAgents";
	private String createAgentURL = "http://localhost:8000/admin-agent-creation/saveAgent";

	
	@RequestMapping("/findAll")
	public AgentList getAll(){
		
		AgentList list = restTemplate.getForObject(findAgentURL, AgentList.class);
		return list;
	}
	 

	@RequestMapping(value = "/addNew")
	public ResponseEntity<User> addNewAgent(@RequestBody User a) {
		
		restTemplate.postForObject(createAgentURL, a, User.class);
		return new ResponseEntity<User>(a, HttpStatus.OK);
	}

}