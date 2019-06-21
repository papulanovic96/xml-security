package com.megatravel.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.model.AccommodationCategory;
import com.megatravel.repository.AccommodationCategoryRepository;

@Service
public class AccommodationCategoryService {

	@Autowired
	private AccommodationCategoryRepository acRepository;
	
	public AccommodationCategory save(AccommodationCategory newCategory) {
		return acRepository.save(newCategory);
	}
	
	public void delete(AccommodationCategory newCategory) {
		acRepository.delete(newCategory);
	}
	
	public List<AccommodationCategory> findAll() {
		return acRepository.findAll();
	}
	
	public AccommodationCategory findById(Long id) {
		return acRepository.findById(id).orElse(null);
	}
	
	@Transactional
	public boolean modifyAccommodationCategory(AccommodationCategory aCategory) {
		AccommodationCategory newCat = acRepository.findById(aCategory.getId()).orElse(null);
		if(newCat == null) {
			return false;
		} else {
			acRepository.modifyCategory(aCategory.getId(), aCategory.getName());
			return true;
		}
	}
	
}
