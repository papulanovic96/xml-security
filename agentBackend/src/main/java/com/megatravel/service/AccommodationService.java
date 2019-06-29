package com.megatravel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.dto.AccommodationDTO;
import com.megatravel.dto.PriceInSeasonDTO;
import com.megatravel.model.Accommodation;
import com.megatravel.model.AccommodationCategory;
import com.megatravel.model.AdditionalServices;
import com.megatravel.model.Agent;
import com.megatravel.model.PriceInSeason;
import com.megatravel.repository.AccommodationRepository;
import com.megatravel.repository.PriceInSeasonRepository;

@Service
public class AccommodationService {
	
	@Autowired
	private AccommodationRepository accommodationRepository;
	
	@Autowired
	private PriceInSeasonRepository pisRepository;
	
	public List<Accommodation> findByCategory(AccommodationCategory categ) {
		return accommodationRepository.findByCategory(categ);
	}
	public void save(Accommodation acc) {
		accommodationRepository.save(acc); 
	}
	
	
	
	public List<PriceInSeasonDTO> getPriceInSeasonByAcc(long id){
		
		List<PriceInSeason> prices = pisRepository.getPriceInSeason(id);
		List<PriceInSeasonDTO> pricesDTO = new ArrayList<>();
		
		for(int i = 0; i < prices.size(); i++) {
			pricesDTO.add(new PriceInSeasonDTO(prices.get(i)));
		}
		return pricesDTO;
	
		
	}
}
