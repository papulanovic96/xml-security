package com.megatravel.service;

import java.util.Date;
import java.util.List;

import javax.xml.soap.MessageFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

import com.megatravel.config.SOAPConnector;
import com.megatravel.dto.soap.CreateReservationRequest;
import com.megatravel.dto.soap.CudReservationResponse;
import com.megatravel.dto.soap.UpdateReservationRequest;
import com.megatravel.exception.ExceptionResponse;
import com.megatravel.model.Accommodation;
import com.megatravel.model.EndUser;
import com.megatravel.model.Reservation;
import com.megatravel.model.ReservationStatus;
import com.megatravel.repository.ReservationRepository;

@Service
public class ReservationService {

	private final String AGENT_APP = "https://localhost8443/agent-backend/";

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private AccommodationService accommodationService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private SOAPConnector soapConnector;

	@Transactional(readOnly = true)
	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Reservation findById(long id) {
		return reservationRepository.findById(id).orElse(null);
	}


	@Transactional(rollbackFor = Exception.class)
	public void save(Reservation reservation) {
		reservationRepository.save(reservation);
	}
	
	//TODO till and from cannot be before current date
	@Transactional(rollbackFor = Exception.class)
	public CudReservationResponse create(CreateReservationRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		EndUser client = null;
		if (!(authentication instanceof AnonymousAuthenticationToken))
			client = userService.findEndUser(authentication.getName());
		
		Accommodation accommodation = accommodationService.findByName(request.getAccommodationName());
		
		if (request.getTillDate() == null || request.getFromDate() == null)
			throw new ExceptionResponse("Select 'from' and 'till' date, please.", HttpStatus.BAD_REQUEST);
		
		if (request.getFromDate().compareTo(request.getTillDate()) >= 0)
			throw new ExceptionResponse("'From' date must be before 'till's!", HttpStatus.BAD_REQUEST);

		if (accommodation == null)
			throw new ExceptionResponse("Acommodation with name '" + request.getAccommodationName() + "' does not exist!", HttpStatus.BAD_REQUEST);
		
		if (accommodationService.checkAvailability(request.getFromDate(), request.getTillDate(), request.getAccommodationName()) == null)
			throw new ExceptionResponse("Acommodation is not available in that period!", HttpStatus.BAD_REQUEST);

		Reservation reservation = new Reservation();
		reservation.setAccommodation(accommodation);
		reservation.setStatus(ReservationStatus.ON_HOLD);
		reservation.setFromDate(request.getFromDate());
		reservation.setTillDate(request.getTillDate());
		
		reservationRepository.save(reservation);
		
		client.getReservations().add(reservation);
		userService.save(client);
		
		CudReservationResponse response = null;
		
		try {
			SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory(MessageFactory.newInstance());
	        messageFactory.afterPropertiesSet();

	        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(messageFactory);
	        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

	        marshaller.setContextPath("com.megatravel.model");
	        marshaller.afterPropertiesSet();

	        webServiceTemplate.setMarshaller(marshaller);
	        webServiceTemplate.setUnmarshaller(marshaller);
	        webServiceTemplate.afterPropertiesSet();
	            
	        response = (CudReservationResponse) soapConnector.callWebService(AGENT_APP + "booking/reservation", request);

	        return response;

		} catch (Exception e) {
			e.printStackTrace();
		}			          
		
        return response;
    				
    }

	public List<Reservation> cancel(UpdateReservationRequest request) {
		Reservation reservation = reservationRepository.findById(request.getId()).orElse(null);
		
		if (reservation == null)
			throw new ExceptionResponse("Reservation with id '" + request.getId() + "' does not exist!", HttpStatus.BAD_REQUEST);
		
		reservation.setStatus(ReservationStatus.CANCELED);
		
		try {
            SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory(MessageFactory.newInstance());
            messageFactory.afterPropertiesSet();

            WebServiceTemplate webServiceTemplate = new WebServiceTemplate(messageFactory);
            Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

            marshaller.setContextPath("com.megatravel.model");
            marshaller.afterPropertiesSet();

            webServiceTemplate.setMarshaller(marshaller);
            webServiceTemplate.setUnmarshaller(marshaller);
            webServiceTemplate.afterPropertiesSet();

            request.setStatus(ReservationStatus.CANCELED);
            
            CudReservationResponse response = (CudReservationResponse) soapConnector.callWebService(AGENT_APP + "booking/reservation", request);
			            
    		reservationRepository.save(reservation);

    		return reservationRepository.findAll();
    				
        } catch (Exception s) {
        	s.printStackTrace();
        }
		
		return reservationRepository.findAll();
	}

	public Reservation findReservationWithAccommodation(long accommodationId, long clientd, Date fromDate, Date tillDate) {
		return reservationRepository.findReservationWithAccommodation(accommodationId, clientd, fromDate, tillDate);
	}

	public String update(UpdateReservationRequest request) {
		Reservation reservation = reservationRepository.findById(request.getId()).orElse(null);
		
		if (reservation == null)
			throw new ExceptionResponse("Reservation with id '" + request.getId() + "' does not exist!", HttpStatus.BAD_REQUEST);
		
		reservation.setStatus(request.getStatus());
				
		return "Reservation with id '" + request.getId() + "' has been: " + request.getStatus().name();
	}

}
