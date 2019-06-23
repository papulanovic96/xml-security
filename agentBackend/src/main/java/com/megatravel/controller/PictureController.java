package com.megatravel.controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.megatravel.service.PictureService;


@RestController
@RequestMapping("/pictures")
public class PictureController {

	@Autowired
	PictureService pictureService;
	
	
	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/upload", produces =  MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity uploadPictures(@RequestParam("file") MultipartFile[] images, @RequestParam("accId") long accId){
		try {
			pictureService.uploadPictures(images, accId);
		} catch (IOException e) {
			
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	
	@ResponseBody
	@PostMapping(value = "/getPicture", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage(@RequestBody long id) {
		byte[] binaryImage = pictureService.getPictureById(id);
		return binaryImage;
	}
	
}


