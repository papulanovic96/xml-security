package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.repository.TestRepository;

import com.example.model.Test;



@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class TestController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private TestRepository testRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Iterable<Test> getAllUsers() {
		// This returns a JSON or XML with the users
		return testRepository.findAll();
	}
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Test n = new Test();
		n.setName(name);
		n.setLast(email);
		testRepository.save(n);
		return "Saved";
	}

	
}