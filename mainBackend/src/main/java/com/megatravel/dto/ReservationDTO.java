package com.megatravel.dto;

import java.util.Date;

import com.megatravel.model.ReservationStatus;

public class ReservationDTO {

	private long id;
	
	private AccommodationDTO accommodation;
    
	private Date fromDate;
    
	private Date tillDate;
    
	private ReservationStatus status;
	
	public ReservationDTO() {
		
	}

    public ReservationDTO(long id, AccommodationDTO accommodation, Date fromDate, Date tillDate, ReservationStatus status) {
		super();
		this.id = id;
		this.accommodation = accommodation;
		this.fromDate = fromDate;
		this.tillDate = tillDate;
		this.status = status;
	}

    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AccommodationDTO getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(AccommodationDTO accommodation) {
		this.accommodation = accommodation;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getTillDate() {
		return tillDate;
	}

	public void setTillDate(Date tillDate) {
		this.tillDate = tillDate;
	}

	public ReservationStatus setStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}
    
}
