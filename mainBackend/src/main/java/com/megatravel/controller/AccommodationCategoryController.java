package com.megatravel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.megatravel.model.AccommodationCategory;
import com.megatravel.service.AccommodationCategoryService;

@Controller
@RequestMapping("/accommodation-category")
public class AccommodationCategoryController {
	
	@Autowired
	private AccommodationCategoryService acService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> newCategory(@RequestBody AccommodationCategory aCategory) {
			List<AccommodationCategory> listOfCategories = acService.findAll();
			for(AccommodationCategory ac : listOfCategories) {
			if(aCategory.getName().equalsIgnoreCase(ac.getName())) {
				return new ResponseEntity<String>("Category with name: " + ac.getName() + " already exists!", HttpStatus.CONFLICT);
			}
		}
			acService.save(aCategory);
			return new ResponseEntity<String>("Successfully added new category!", HttpStatus.CREATED);
			
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> requestMethodName(@PathVariable Long id) {
		AccommodationCategory newCategory = acService.findById(id);
		if(newCategory == null) {
			return new ResponseEntity<String>("Category not found! #404", HttpStatus.NOT_FOUND);
		} else {
			acService.delete(newCategory);
			return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> findById(@PathVariable Long id) {
			AccommodationCategory newCategory = acService.findById(id);
			if(newCategory == null) {
				return new ResponseEntity<String>("Category not found!", HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<String>("Category with id: " + newCategory.getId() + " found!", HttpStatus.OK);
			}
	}
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AccommodationCategory>> findAll() {
		List<AccommodationCategory> newList = acService.findAll();
		if(newList == null) {
			return new ResponseEntity<List<AccommodationCategory>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AccommodationCategory>>(newList, HttpStatus.OK);
	}


	@RequestMapping(value = "/modify/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> modifyType(@PathVariable Long id , @RequestBody AccommodationCategory aCategory){
		aCategory.setId(id);
		List<AccommodationCategory> listOfCategories = acService.findAll();

			for(AccommodationCategory ac : listOfCategories) {
				if(aCategory.getName().equalsIgnoreCase(ac.getName())) {
					return new ResponseEntity<String>("Category with name: " + ac.getName() + " already exists!", HttpStatus.CONFLICT);
				}
			}
			boolean successed = acService.modifyAccommodationCategory(aCategory);
			if(successed) {
				return new ResponseEntity<String>("Category successfully modified!", HttpStatus.OK);
			}
		return new ResponseEntity<String>("Failed to modify unexisting category!", HttpStatus.NOT_FOUND);
	}
}