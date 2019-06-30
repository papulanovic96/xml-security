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
	private AccommodationCategoryRepository categRepos;
	private AccommodationTypeRepository typeRepos;
	private AccommodationCategory accCateg;
	private AccommodationType accType;
	@Autowired
    public AccommodationEndpoint(AccommodationRepository accommodationRepository,AccommodationCategoryRepository accommodationCategoryRepository, 
			 AccommodationTypeRepository accommodationTypeRepository) {
       
		this.accommodationRepository = accommodationRepository;
        this.categRepos = accommodationCategoryRepository;
        this.typeRepos = accommodationTypeRepository;
        
           }
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccommodationCategoryRequest")
    @ResponsePayload
    public GetAccommodationCategoryResponse getCategory(@RequestPayload GetAccommodationCategoryRequest request) {
		  
		GetAccommodationCategoryResponse response = new GetAccommodationCategoryResponse();
		accCateg = categRepos.findByName(request.getName());
        response.setAccommodationsOfCategory(accommodationRepository.findByCategory(accCateg));
        
        return response;
    }
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccommodationTypeRequest")
    @ResponsePayload
    public GetAccommodationTypeResponse getType(@RequestPayload GetAccommodationTypeRequest request) {
		
		GetAccommodationTypeResponse response = new GetAccommodationTypeResponse();
		accType = typeRepos.findByName(request.getName());
		response.setAccommodationsOfType(accommodationRepository.findByType(accType));
		
        return response;
    }
	

}
