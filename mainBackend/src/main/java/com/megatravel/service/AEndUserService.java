package com.megatravel.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.converter.EndUserConverter;
import com.megatravel.dto.EndUserDTO;
import com.megatravel.model.EndUser;
import com.megatravel.repository.UserRepository;

@Service
public class AEndUserService {

	
	@Autowired
	private UserRepository uRepository;
	
	public void delete(EndUserDTO eUser) {
		uRepository.deleteById(eUser.getId());
	}
	
	@Transactional
	public void block(EndUserDTO eUser) {
		EndUser endUser = EndUserConverter.toEntity(eUser);
			uRepository.blocked(endUser.getUsername());
	}
	@Transactional
	public void active(EndUserDTO eUser) {
		EndUser endUser = EndUserConverter.toEntity(eUser);
		uRepository.activated(endUser.getUsername());
	}
	
	public List<EndUserDTO> findAll() {
		List<EndUser> userList = uRepository.findEndUsers();
		List<EndUserDTO> userListDTO = EndUserConverter.fromEntityList(userList, e -> EndUserConverter.fromEntity(e));
		return userListDTO;
	}
	
	public EndUser findByUsername(String uName) {
		return uRepository.findEndUserByUsername(uName);
	}
}
