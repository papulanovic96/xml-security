package com.megatravel.service;

import java.util.List;

import javax.transaction.Transactional;

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
	
	@Transactional
	public void block(EndUser eUser) {
			uRepository.blocked(eUser.getUsername());
	}
	@Transactional
	public void active(EndUser eUser) {
		uRepository.activated(eUser.getUsername());
	}
	
	public List<EndUser> findAll() {
		return uRepository
		.findEndUsers();
	}
	
	public EndUser findByUsername(String uName) {
		return uRepository.findEndUserByUsername(uName);
	}
}
