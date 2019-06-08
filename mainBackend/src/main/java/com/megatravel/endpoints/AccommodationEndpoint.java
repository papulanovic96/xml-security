package com.megatravel.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.megatravel.model.GetAccommodationCategoryRequest;
import com.megatravel.model.GetAccommodationCategoryResponse;
import com.megatravel.model.GetAccommodationTypeRequest;
import com.megatravel.model.GetAccommodationTypeResponse;
import com.megatravel.repository.AccommodationRepository;

public class AccommodationEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.megatravel.com/booking";
	
	private AccommodationRepository accommodationRepository;

	@Autowired
    public AccommodationEndpoint(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccommodationCategoryRequest")
    @ResponsePayload
    public GetAccommodationCategoryResponse getCategory(@RequestPayload GetAccommodationCategoryRequest request) {
		GetAccommodationCategoryResponse response = new GetAccommodationCategoryResponse();
        response.setAccommodations(accommodationRepository.findByCategory(request.getCategory()));
 
        return response;
    }
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccommodationTypeRequest")
    @ResponsePayload
    public GetAccommodationTypeResponse getType(@RequestPayload GetAccommodationTypeRequest request) {
		GetAccommodationTypeResponse response = new GetAccommodationTypeResponse();
        response.setAccommodations(accommodationRepository.findByType(request.getType()));
 
        return response;
    }

}
