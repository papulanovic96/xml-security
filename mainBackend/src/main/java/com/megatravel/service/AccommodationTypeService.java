package com.megatravel.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.model.AccommodationType;
import com.megatravel.repository.AccommodationTypeRepository;

@Service
public class AccommodationTypeService {

	@Autowired
	private AccommodationTypeRepository atRepository;
	
	public AccommodationType save(AccommodationType aType) {
		return atRepository.save(aType);
		
	}
	
	public void delete(AccommodationType aType) {
		atRepository.delete(aType);
	}
	
	public List<AccommodationType> findAll() {
		return atRepository.findAll();
	}
	
	public AccommodationType findById(Long id) {
		return atRepository.findById(id).orElse(null);
	}
	
	public AccommodationType findByName(String name) {
		return atRepository.findByName(name);
	}
	
	@Transactional
	public boolean modifyAccommodationType(AccommodationType aType) {
		AccommodationType newType = atRepository.findById(aType.getId()).orElse(null);
		if(newType == null) {
			return false;
		} else {
			atRepository.modifyType(aType.getId(), aType.getName());
			return true;
		}
	}
}
