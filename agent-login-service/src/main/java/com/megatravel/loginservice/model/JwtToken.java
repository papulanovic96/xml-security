package com.megatravel.loginservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class JwtToken {

	@Id
	@GeneratedValue
	private long id;
	
	private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    public JwtToken() {
    }

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
