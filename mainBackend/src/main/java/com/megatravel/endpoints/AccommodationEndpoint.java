package com.megatravel.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.megatravel.model.AccommodationCategory;
import com.megatravel.model.AccommodationType;
import com.megatravel.model.GetAccommodationCategoryRequest;
import com.megatravel.model.GetAccommodationCategoryResponse;
import com.megatravel.model.GetAccommodationTypeRequest;
import com.megatravel.model.GetAccommodationTypeResponse;
import com.megatravel.repository.AccommodationCategoryRepository;
import com.megatravel.repository.AccommodationRepository;
import com.megatravel.repository.AccommodationTypeRepository;

@Endpoint
public class AccommodationEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.megatravel.com/accommodation";

	private AccommodationRepository accommodationRepository;
	
	private AccommodationCategoryRepository accommodationCategoryRepository;
	
	private AccommodationTypeRepository accommodationTypeRepository;
	
//	@Autowired
//	private WebServiceTemplate wst;
	
	
	@Autowired
    public AccommodationEndpoint(AccommodationRepository accommodationRepository, 
    							 AccommodationCategoryRepository accommodationCategoryRepository, 
    							 AccommodationTypeRepository accommodationTypeRepository) 
	{
        this.accommodationRepository = accommodationRepository;
        this.accommodationCategoryRepository = accommodationCategoryRepository;
        this.accommodationTypeRepository = accommodationTypeRepository;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccommodationCategoryRequest")
    @ResponsePayload
    public GetAccommodationCategoryResponse getCategory(@RequestPayload GetAccommodationCategoryRequest category) {
		
		GetAccommodationCategoryResponse response = new GetAccommodationCategoryResponse();
		
		AccommodationCategory ac = accommodationCategoryRepository.findByName(category.getName());
		
		System.out.println("UNELI STE KAT: " + ac.getName());
		
        response.setAccommodationsOfCategory(accommodationRepository.findByCategory(ac));
        
        return response;
    }
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccommodationTypeRequest")
    @ResponsePayload
    public GetAccommodationTypeResponse getType(@RequestPayload GetAccommodationTypeRequest type) {
		GetAccommodationTypeResponse response = new GetAccommodationTypeResponse();
		
		AccommodationType at = accommodationTypeRepository.findByName(type.getName());
		
		System.out.println("UNELI STE TIP: " + at.getName());
		
		
		response.setAccommodationsOfType(accommodationRepository.findByType(at));
		

        return response;
    }
	

}
