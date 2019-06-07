package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.UPerson;
import com.example.repository.PersonRepository;

@Service
public class PersonService implements PersonInterface {
	
	@Autowired
	private PersonRepository personRepository;
	
	
	@Override
	public List<UPerson> findAll() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}

	@Override
	public void create(UPerson newPerson) {
		// TODO Auto-generated method stub
		
	}


}
