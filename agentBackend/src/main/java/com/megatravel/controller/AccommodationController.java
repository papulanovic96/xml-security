package com.megatravel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import javax.ws.rs.core.MediaType;

import com.auth0.jwt.JWT;
import com.megatravel.dto.AccommodationDTO;
import com.megatravel.dto.PriceInSeasonDTO;
import com.megatravel.model.Accommodation;
import com.megatravel.model.AccommodationCategory;
import com.megatravel.model.AccommodationType;
import com.megatravel.model.AdditionalServices;
import com.megatravel.model.Agent;
import com.megatravel.model.Message;
import com.megatravel.model.PriceInSeason;
import com.megatravel.repository.AccommodationRepository;
import com.megatravel.repository.AccommodationServicesRepository;
import com.megatravel.repository.PriceInSeasonRepository;
import com.megatravel.service.AccommodationService;
import com.megatravel.service.AccomodationTypeService;
import com.megatravel.service.UserService;


@RestController
@RequestMapping("/accommodation")
public class AccommodationController {
	

	@Autowired
	private AccommodationService accommodationService;
	
	@Autowired
	private AccomodationTypeService accTypeService;
	@Autowired
	private AccommodationRepository accommodationRepository;
	
	@Autowired
	private AccommodationServicesRepository accommodationServicesRepository;
	
	@Autowired
	private PriceInSeasonRepository priceInSeasonRepository;
	
	@Autowired
	private UserService userService;
		

	@RequestMapping(value="/addNewAccommodation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<AccommodationDTO> add(@RequestBody Accommodation accommodation) {
		
		Agent agent = userService.getCurrentAgent();
		
		accommodation.setOwnedBy(agent);
		Accommodation acc = accommodationRepository.save(accommodation);
		return new ResponseEntity<>(new AccommodationDTO(acc), HttpStatus.OK);

	}

	@RequestMapping(value="/getAllAccTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<List<AccommodationType>> getAllAccTypes(){
		
		List<AccommodationType> types = accTypeService.findAll();
		
		return new ResponseEntity<>(types, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllAccServices", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<List<AdditionalServices>> getAllAccServices(){
		
		List<AdditionalServices> services = accommodationServicesRepository.findAll();
		return new ResponseEntity<>(services, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllPrices", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<List<PriceInSeason>> getAllPrices(){
		List<PriceInSeason> prices = priceInSeasonRepository.findAll();
		return new ResponseEntity<>(prices, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllAcc", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Accommodation>> getAllAcc(){
		
		List<Accommodation> accs = accommodationRepository.findAll();
		return new ResponseEntity<>(accs, HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteAcc", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity delete(@RequestBody long accId){
					
		accommodationRepository.deleteById(accId);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
		
	@RequestMapping(value = "/getPriceInSeason", method = RequestMethod.POST, produces =  MediaType.APPLICATION_JSON)
	public ResponseEntity<List<PriceInSeasonDTO>> getPriceInSeasonByAcc(@RequestBody long id){
		
		List<PriceInSeasonDTO> prices =  accommodationService.getPriceInSeasonByAcc(id);
		
		return new ResponseEntity<>(prices, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addNewPriceInSeason", method = RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON)
	public ResponseEntity addNewPriceInSeason(@RequestBody PriceInSeasonDTO pis){
	//, long accId
		
		Accommodation acc = accommodationRepository.findOneById(pis.getAccId());
		
		PriceInSeason priceInSeason = new PriceInSeason();
		priceInSeason.setCurrency(pis.getCurrency());
		priceInSeason.setPrice(pis.getPrice());
		priceInSeason.setInMonth(pis.getInMonth());
		
		acc.getPriceInSeason().add(priceInSeason);
		accommodationRepository.save(acc);
		
		return new ResponseEntity<>(HttpStatus.OK);
	
	}
	
	@RequestMapping(value = "/deletePriceInSeason", method = RequestMethod.POST, produces =  MediaType.APPLICATION_JSON)
	public ResponseEntity deletePriceInSeason(@RequestBody long id_pis){
		
		priceInSeasonRepository.deleteById(id_pis);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
