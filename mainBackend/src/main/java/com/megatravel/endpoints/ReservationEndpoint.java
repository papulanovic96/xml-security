package com.megatravel.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.megatravel.model.CreateReservationRequest;
import com.megatravel.model.CreateReservationResponse;
import com.megatravel.repository.ReservationRepistory;

@Endpoint
public class ReservationEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.megatravel.com/reservation";

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
