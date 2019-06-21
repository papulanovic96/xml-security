package com.megatravel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.config.SOAPConnector;
import com.megatravel.model.EndUser;
import com.megatravel.model.SyncUserResponse;
import com.megatravel.model.User;
import com.megatravel.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SOAPConnector soap_client;
	
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	public EndUser findEndUser(String username) {
		return userRepository.findEndUserByUsername(username);
	}
	
	public List<EndUser> findEndUsers() {
		return userRepository.findEndUsers();
	}
	
	public void save(EndUser eu) {
		userRepository.saveAndFlush(eu);
	}
	
	public void syncUsers() {
		SyncUserResponse response = soap_client.syncUserRequest();
		
	}
	
}
