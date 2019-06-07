package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.UPerson;

@Service
public interface PersonInterface {

	public List<UPerson> findAll();
	public void create(UPerson newPerson);
}
