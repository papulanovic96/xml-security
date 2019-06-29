package com.megatravel.converter;

import java.util.ArrayList;
import java.util.List;

import com.megatravel.dto.AccommodationDTO;
import com.megatravel.dto.CommentDTO;
import com.megatravel.model.Accommodation;
import com.megatravel.model.AdditionalServices;
import com.megatravel.model.Comment;
import com.megatravel.model.ImageResource;

public class AccommodationConverter extends AbstractConverter{

	public static AccommodationDTO fromEntity(Accommodation a) {
		AccommodationDTO aDto = new AccommodationDTO();
		aDto.setId(a.getId());
		aDto.setName(a.getName());
		aDto.setType(a.getType());
		aDto.setCategory(a.getCategory());
		aDto.setOwnedBy(AgentConverter.fromEntity(a.getOwnedBy()));
		aDto.setFromDate(a.getFromDate());
		aDto.setTillDate(a.getTillDate());
		aDto.setDistance(a.getDistance());
		aDto.setDescription(a.getDescription());
		
		List<ImageResource> imagesResource = a.getImage();
		List<String> imageUrl = new ArrayList<String>();
		for (ImageResource iR : imagesResource) {
			imageUrl.add(iR.getPath());
		}
		aDto.setImage(imageUrl);
		
		aDto.setAddress(a.getAddress());
		aDto.setPriceInSeason(a.getPriceInSeason());
		
		List<AdditionalServices> additList = a.getAdditionalService();
		List<String> addStringList = new ArrayList<String>();
		for (AdditionalServices aS : additList) {
			addStringList.add(aS.getName());
		}
		aDto.setAdditionalService(addStringList);
		
		aDto.setAvailable(a.isAvailable());
		aDto.setCancelation(a.getCancelation());
		aDto.setRate(a.getRate());
		
		List<Comment> comments = a.getComments();
		List<CommentDTO> commentsDTO = new ArrayList<CommentDTO>();
		for(Comment com : comments) {
			CommentDTO cDTO = new CommentDTO();
			cDTO.setId(com.getId());
			cDTO.setContent(com.getContent());
			cDTO.setVisible(com.isVisible());
			cDTO.setPostedBy(com.getPostedBy().getUsername());
			commentsDTO.add(cDTO);
		}
		return aDto;
	}
	
	public static Accommodation toEntity(AccommodationDTO d) {
		Accommodation a = new Accommodation();
		a.setAddress(d.getAddress());
		a.setAvailable(d.isAvailable());
		a.setCancelation(d.getCancelation());
		a.setCapacity(d.getCapacity());
		a.setCategory(d.getCategory());
		a.setDescription(d.getDescription());
		a.setDistance(d.getDistance());
		a.setFromDate(d.getFromDate());
		a.setId(d.getId());
		a.setName(d.getName());
		a.setOwnedBy(AgentConverter.toEntity(d.getOwnedBy()));
		a.setPriceInSeason(d.getPriceInSeason());
		a.setRate(d.getRate());
		a.setTillDate(d.getTillDate());
		a.setType(d.getType());
		List<String> imageUrl = d.getImage();
		List<ImageResource> imgResource = new ArrayList<ImageResource>();
		if(imageUrl != null) {
			for(String xs : imageUrl) {
				ImageResource newReso = new ImageResource();
				newReso.setPath(xs);
				imgResource.add(newReso);
			}
		}
		a.setImage(imgResource);
		
		List<String> addServ = d.getAdditionalService();
		List<AdditionalServices> addServList = new ArrayList<AdditionalServices>();
		if(addServ != null) {
			for(String xs : addServ) {
				AdditionalServices newService = new AdditionalServices();
				newService.setName(xs);
				addServList.add(newService);
			}
		}
		a.setAdditionalService(addServList);
		
		List<CommentDTO> dtoComment = d.getComments();
		List<Comment> listComment = new ArrayList<Comment>();
		if(dtoComment != null) {
			for(CommentDTO dc : dtoComment) {
				Comment newComment = new Comment();
				newComment.setId(dc.getId());
				newComment.setContent(dc.getContent());
				newComment.setVisible(dc.isVisible());
				listComment.add(newComment);
			}
		}
		a.setComments(listComment);
		return a;
	}
}
