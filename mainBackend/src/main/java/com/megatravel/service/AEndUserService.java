package com.megatravel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.model.EndUser;
import com.megatravel.model.User;
import com.megatravel.model.UserStatus;
import com.megatravel.repository.UserRepository;

@Service
public class AEndUserService {

	
	@Autowired
	private UserRepository uRepository;

	
	public void delete(EndUser eUser) {
		uRepository.delete(eUser);
	}
	
	public void block(EndUser eUser) {
		eUser.setStatus(UserStatus.BLOCKED);
	}
	
	public void active(EndUser eUser) {
		eUser.setStatus(UserStatus.ACTIVE);
	}
	
	public List<User> findAll() {
		return uRepository
		.findAll();
	}
	
	public User findByUsername(String uName) {
		return uRepository.findEndUserByUsername(uName);
	}
}
