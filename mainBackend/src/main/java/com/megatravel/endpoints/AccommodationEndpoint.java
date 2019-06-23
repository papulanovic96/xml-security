package com.megatravel.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.megatravel.model.Accommodation;
import com.megatravel.model.AccommodationCategory;
import com.megatravel.model.AccommodationType;
import com.megatravel.model.CreateAccommodationRequest;
import com.megatravel.model.CreateAccommodationResponse;
import com.megatravel.model.GetAccommodationCategoryRequest;
import com.megatravel.model.GetAccommodationCategoryResponse;
import com.megatravel.model.GetAccommodationTypeRequest;
import com.megatravel.model.GetAccommodationTypeResponse;
import com.megatravel.service.AccommodationCategoryService;
import com.megatravel.service.AccommodationService;
import com.megatravel.service.AccommodationTypeService;

@Endpoint
public class AccommodationEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.megatravel.com/accommodation";

	private AccommodationService  accommodationService;
	
	private AccommodationCategoryService accommodationCategoryService;
	
	private AccommodationTypeService accommodationTypeService;
	
	
	@Autowired
    public AccommodationEndpoint(AccommodationService accommodationService, 
						    	 AccommodationCategoryService accommodationCategoryService, 
						    	 AccommodationTypeService accommodationTypeService) 
	{
        this.accommodationService = accommodationService;
        this.accommodationCategoryService = accommodationCategoryService;
        this.accommodationTypeService = accommodationTypeService;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccommodationCategoryRequest")
    @ResponsePayload
    public GetAccommodationCategoryResponse getCategory(@RequestPayload GetAccommodationCategoryRequest category) {
		
		GetAccommodationCategoryResponse response = new GetAccommodationCategoryResponse();
		
		AccommodationCategory ac = accommodationCategoryService.findByName(category.getName());
		
        response.setAccommodationsOfCategory(accommodationService.findByCategory(ac));
        
        return response;
    }
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccommodationTypeRequest")
    @ResponsePayload
    public GetAccommodationTypeResponse getType(@RequestPayload GetAccommodationTypeRequest type) {
		GetAccommodationTypeResponse response = new GetAccommodationTypeResponse();
		
		AccommodationType at = accommodationTypeService.findByName(type.getName());

		
		response.setAccommodationsOfType(accommodationService.findByType(at));
		

        return response;
    }
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createAccommodationRequest")
    @ResponsePayload
    public CreateAccommodationResponse createAccommodation(@RequestPayload CreateAccommodationRequest request) {
		CreateAccommodationResponse response = new CreateAccommodationResponse();
		
		Accommodation accommodation = request.getAccommodation();
		
		//accommodation validator
		//accommodationService.findAccommodation(accommodation.getName());
		
		accommodationService.save(accommodation);
		
		
		return response;
	
	}
	
	
	
}