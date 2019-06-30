package com.megatravel.dto;

public class AddressDTO {
	
	private Long id;
	private String country;
	private String city;
	private int zip;
	private String street;
	private double longitude;
	private double latitude;
	
	public AddressDTO() {
		
	}
	
	public AddressDTO(Long id, String country, String city, int zip, String street, double longitude, double latitude) {
		super();
		this.id = id;
		this.country = country;
		this.city = city;
		this.zip = zip;
		this.street = street;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}	
	
}
