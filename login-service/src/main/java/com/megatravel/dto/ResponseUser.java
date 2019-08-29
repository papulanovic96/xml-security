package com.megatravel.dto;

import java.util.List;

public class ResponseUser {
	
	private String username;
		
	private List<ResponseRole> roles;
	
	public ResponseUser() {
		
	}

	public ResponseUser(String username, List<ResponseRole> roles) {
		super();
		this.username = username;
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<ResponseRole> getRoles() {
		return roles;
	}

	public void setRoles(List<ResponseRole> roles) {
		this.roles = roles;
	}

}
