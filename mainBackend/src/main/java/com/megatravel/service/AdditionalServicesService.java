package com.megatravel.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.model.AccommodationType;
import com.megatravel.model.AdditionalServices;
import com.megatravel.repository.AdditionalServicesRepository;

@Service
public class AdditionalServicesService {
	
	@Autowired
	private AdditionalServicesRepository asRepository;
	
	public AdditionalServices save(AdditionalServices aService) {
		return asRepository.save(aService);
		
	}
	
	public void delete(AdditionalServices aService) {
		asRepository.delete(aService);
	}
	
	public List<AdditionalServices> findAll() {
		return asRepository.findAll();
	}
	
	public AdditionalServices findById(Long id) {
		return asRepository.findById(id).orElse(null);
	}
	
	@Transactional
	public boolean modifyAdditionalServices(AdditionalServices aService) {
		AdditionalServices newService = asRepository.findById(aService.getId()).orElse(null);
		if(newService == null) {
			return false;
		} else {
			asRepository.modifyAS(aService.getId(), aService.getName());
			return true;
		}
	}

}
