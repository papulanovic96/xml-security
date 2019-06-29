package com.megatravel.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.megatravel.model.Accommodation;
import com.megatravel.model.AccommodationCategory;
import com.megatravel.model.AccommodationType;
import com.megatravel.model.AdditionalServices;
import com.megatravel.model.Address;
import com.megatravel.model.Agent;
import com.megatravel.model.Cancelation;
import com.megatravel.model.Comment;
import com.megatravel.model.ImageResource;
import com.megatravel.model.PriceInSeason;

public class AccommodationDTO {
	
	private long id;
	
	private String name;
    
	private AccommodationType type;
    
	private AccommodationCategory category;
    
	private UserDTO ownedBy;
    
	private Date fromDate;
    
	private Date tillDate;
    
	private int distance;
    
	private String description;
    
	private List<ImageResource> image;
    
	private Address address;
    
	private long capacity;
    
	private PriceInSeason priceInSeason;
    
	private List<AdditionalServices> additionalService;
    
	private boolean available;
    
	private Cancelation cancelation;
    
	private String rate;
    
	private List<CommentDTO> comments;
	
	public AccommodationDTO(long id, String name, AccommodationType type, AccommodationCategory category, UserDTO ownedBy,
			Date fromDate, Date tillDate, int distance, String description, List<ImageResource> image, Address address,
			long capacity, PriceInSeason priceInSeason, List<AdditionalServices> additionalService, boolean available,
			Cancelation cancelation, String rate, List<CommentDTO> comments) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.category = category;
		this.ownedBy = ownedBy;
		this.fromDate = fromDate;
		this.tillDate = tillDate;
		this.distance = distance;
		this.description = description;
		this.image = image;
		this.address = address;
		this.capacity = capacity;
		this.priceInSeason = priceInSeason;
		this.additionalService = additionalService;
		this.available = available;
		this.cancelation = cancelation;
		this.rate = rate;
		this.comments = comments;
	}

	public AccommodationDTO() {
		
	}

//	public AccommodationDto(Accommodation accommodation) {
//		this.id = accommodation.getId();
//		this.name = accommodation.getName();
//		this.type = accommodation.getType();
//		this.category = accommodation.getCategory();
//		this.agentUsername = accommodation.getOwnedBy().getUsername();
//		this.fromDate = accommodation.getFromDate();
//		this.tillDate = accommodation.getTillDate();
//		this.distance = accommodation.getDistance();
//		this.description = accommodation.getDescription();
//		this.image = accommodation.getImage();
//		this.address = accommodation.getAddress();
//		this.priceInSeason = accommodation.getPriceInSeason();
//		this.additionalService = accommodation.getAdditionalService();
//		this.available = accommodation.isAvailable();
//		this.cancelation = accommodation.getCancelation();
//		this.rate = accommodation.getRate();
//		
//		for (Comment comment: accommodation.getComments()) {
//			this.comments.add(new CommentDto(comment.getId(), comment.getContent(), comment.isVisible(), comment.getPostedBy().getUsername()));
//		}
//		
//	
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public UserDTO getOwnedBy() {
		return ownedBy;
	}

	public void setOwnedBy(UserDTO ownedBy) {
		this.ownedBy = ownedBy;
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

	public List<ImageResource> getImage() {
		return image;
	}

	public void setImage(List<ImageResource> image) {
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

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}

}
