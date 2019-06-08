package com.megatravel.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.megatravel.model.CreateReservationRequest;
import com.megatravel.model.CreateReservationResponse;
import com.megatravel.model.GetAccommodationCategoryRequest;
import com.megatravel.model.GetAccommodationCategoryResponse;
import com.megatravel.repository.AccommodationRepository;
import com.megatravel.repository.ReservationRepistory;

public class ReservationEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.megatravel.com/booking";

	private ReservationRepistory reservationRepository;
	
	@Autowired
    public ReservationEndpoint(ReservationRepistory reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createReservationRequest")
    @ResponsePayload
    public CreateReservationResponse getCategory(@RequestPayload CreateReservationRequest request) {
		CreateReservationResponse response = new CreateReservationResponse();
        
        return response;
    }

}
