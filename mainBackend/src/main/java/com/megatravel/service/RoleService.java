package com.megatravel.service;

import org.springframework.stereotype.Service;

import com.megatravel.model.Role;
import com.megatravel.model.Roles;
import com.megatravel.repository.RoleRepository;

@Service
public class RoleService {

	private RoleRepository roleRepository;
	
	public Role findRoleByName(Roles role) {
		return roleRepository.findByName(role);
	}
	
}
