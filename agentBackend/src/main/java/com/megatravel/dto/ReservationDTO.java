package com.megatravel.dto;

import java.util.Date;



import com.megatravel.model.Accommodation;
import com.megatravel.model.EndUser;
import com.megatravel.model.Reservation;
import com.megatravel.model.ReservationStatus;

public class ReservationDTO {

    protected Accommodation accommodation;
    protected Date fromDate;
    protected Date tillDate;
    protected ReservationStatus status;
    
    public ReservationDTO(Reservation r) {
    	
    	
    	this.accommodation = r.getAccommodation();
    	this.fromDate = r.getFromDate();
    	this.tillDate = r.getTillDate();
    	this.status = r.getStatus();
    }

	public Accommodation getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Accommodation accommodation) {
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

	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}

}
