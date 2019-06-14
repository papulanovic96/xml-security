package com.megatravel.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.amazonaws.transform.Marshaller;
import com.megatravel.model.GetAccommodationCategoryRequest;
import com.megatravel.model.GetAccommodationCategoryResponse;
import com.megatravel.model.GetAccommodationTypeRequest;
import com.megatravel.model.GetAccommodationTypeResponse;
import com.megatravel.repository.AccommodationRepository;

@Endpoint
public class AccommodationEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.megatravel.com/accommodation";
	
	private AccommodationRepository accommodationRepository;
	
	private WebServiceTemplate wst;
	
	
	@Autowired
    public AccommodationEndpoint(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
        
           }
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccommodationCategoryRequest")
    @ResponsePayload
    public GetAccommodationCategoryResponse getCategory(@RequestPayload GetAccommodationCategoryRequest request) {
		GetAccommodationCategoryResponse response = new GetAccommodationCategoryResponse();
        response.setAccommodationsOfCategory(accommodationRepository.findByCategory(request.getCategory()));
 
        System.out.println("stigao " + response.getAccommodationsOfCategory().size());

        
        return response;
    }
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccommodationTypeRequest")
    @ResponsePayload
    public GetAccommodationTypeResponse getType(@RequestPayload GetAccommodationTypeRequest request) {
		GetAccommodationTypeResponse response = new GetAccommodationTypeResponse();
		
		System.out.println(request.getType());
        response.setAccommodationsOfType(accommodationRepository.findByType(request.getType()));
 
        System.out.println("stigao " + response.getAccommodationsOfType().size());

        
        return response;
    }
	

}
