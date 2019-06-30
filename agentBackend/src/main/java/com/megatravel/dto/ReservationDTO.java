package com.megatravel.dto;

import java.util.Date;



import com.megatravel.model.Accommodation;
import com.megatravel.model.EndUser;
import com.megatravel.model.Reservation;

public class ReservationDTO {

	
	protected EndUser reservedBy;
    protected Accommodation accommodation;
    protected Date fromDate;
    protected Date tillDate;
    protected boolean status;
    
    public ReservationDTO(Reservation r) {
    	
    	this.reservedBy = r.getReservedBy();
    	this.accommodation = r.getAccomodation();
    	this.fromDate = r.getFromDate();
    	this.tillDate = r.getTillDate();
    	this.status = r.isStatus();
    }

	public EndUser getReservedBy() {
		return reservedBy;
	}

	public void setReservedBy(EndUser reservedBy) {
		this.reservedBy = reservedBy;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
    
	
}
