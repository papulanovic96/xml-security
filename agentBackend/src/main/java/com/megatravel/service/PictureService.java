package com.megatravel.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.megatravel.model.Accommodation;
import com.megatravel.model.Picture;
import com.megatravel.repository.AccommodationRepository;
import com.megatravel.repository.PictureRepository;

@Service
public class PictureService {

	@Autowired
	PictureRepository pictureRepository;
	
	@Autowired
	AccommodationRepository accommodationRepository;
	
	public void uploadPictures(MultipartFile[] pictures, long accId) throws IOException {
		
		Accommodation acc = accommodationRepository.findOneById(accId);
		
		ArrayList<Picture> picturesModel = new ArrayList<>();
		
		for (MultipartFile picture  : pictures) {
			Picture picModel = new Picture();
			picModel.setPic(picture.getBytes());
			picModel.setAccommodation(acc);
			picturesModel.add(picModel);
		}
		pictureRepository.saveAll(picturesModel);	
		
		
	}
	
	public byte[] getPictureById(long id){
		Picture pic = pictureRepository.getOne(id);
		return pic.getPic();
	}
	
}
