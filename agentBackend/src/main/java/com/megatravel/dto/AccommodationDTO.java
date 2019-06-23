package com.megatravel.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;

import com.megatravel.model.Accommodation;
import com.megatravel.model.AccommodationCategory;
import com.megatravel.model.AccommodationType;
import com.megatravel.model.AdditionalServices;
import com.megatravel.model.Address;
import com.megatravel.model.Cancelation;
import com.megatravel.model.Comment;
import com.megatravel.model.PriceInSeason;

public class AccommodationDTO {

	
	
    protected long id;
    protected AccommodationType type;
    protected AccommodationCategory category;
    protected Date tillDate;
    protected int distance;
    protected String description;
    protected List<String> image;
    protected Address address;
    protected long capacity;
    protected PriceInSeason priceInSeason;
    protected List<AdditionalServices> additionalService;
    protected boolean available;
    protected Cancelation cancelation;
    protected String rate;
    protected List<Comment> comments;
    
    public AccommodationDTO(Accommodation acc)
    {
    	this.id = acc.getId();
    	this.category = acc.getCategory();
    	this.type = acc.getType();
    	this.description = acc.getDescription();
    	this.cancelation = acc.getCancelation();
    	this.capacity = acc.getCapacity();
    	this.address = acc.getAddress();
    	this.tillDate = acc.getTillDate();
    	this.available = acc.isAvailable();
    	this.image = new ArrayList<>();
    	this.comments = acc.getComments();
    	this.priceInSeason = acc.getPriceInSeason();
    	this.rate = acc.getRate();
    	this.additionalService = acc.getAdditionalService();
    	this.distance = acc.getDistance();
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AccommodationType getType() {
		return type;
	}

	public void setType(AccommodationType type) {
		this.type = type;
	}

	public AccommodationCategory getCategory() {
		return category;
	}

	public void setCategory(AccommodationCategory category) {
		this.category = category;
	}

	public Date getTillDate() {
		return tillDate;
	}

	public void setTillDate(Date tillDate) {
		this.tillDate = tillDate;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	public PriceInSeason getPriceInSeason() {
		return priceInSeason;
	}

	public void setPriceInSeason(PriceInSeason priceInSeason) {
		this.priceInSeason = priceInSeason;
	}

	public List<AdditionalServices> getAdditionalService() {
		return additionalService;
	}

	public void setAdditionalService(List<AdditionalServices> additionalService) {
		this.additionalService = additionalService;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Cancelation getCancelation() {
		return cancelation;
	}

	public void setCancelation(Cancelation cancelation) {
		this.cancelation = cancelation;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
