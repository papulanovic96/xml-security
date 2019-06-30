package com.megatravel.converter;

import com.megatravel.dto.AddressDTO;
import com.megatravel.model.Address;

public class AddressConverter extends AbstractConverter{
	
	public static AddressDTO fromEntity(Address e) {
		AddressDTO aNew = new AddressDTO();
		aNew.setCountry(e.getCountry());
		aNew.setCity(e.getCity());
		aNew.setZip(e.getZip());
		aNew.setStreet(e.getStreet());
		aNew.setLongitude(e.getLongitude());
		aNew.setLatitude(e.getLatitude());
		return aNew;
	}
	
	public static Address toEntity(AddressDTO d) {
		Address aNew = new Address();
		aNew.setCity(d.getCity());
		aNew.setCountry(d.getCountry());
		aNew.setLatitude(d.getLatitude());
		aNew.setLongitude(d.getLongitude());
		aNew.setStreet(d.getStreet());
		aNew.setZip(d.getZip());
		return aNew;
	}
}
