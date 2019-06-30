package com.megatravel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.model.JwtDTO;
import com.megatravel.model.LoginDTO;
import com.megatravel.service.LoginInterface;

@RestController
@RequestMapping(value = "")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class LoginController {
	
	@Autowired
    private LoginInterface loginService;
	
	@RequestMapping(value= "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JwtDTO> login(@RequestBody LoginDTO user) {
		
        String token = loginService.login(user.getUsername(), user.getPassword());

        
        System.out.println(user.getUsername() + " "+ user.getPassword());
        HttpHeaders headers = new HttpHeaders();
        List<String> headerlist = new ArrayList<>();
        List<String> exposeList = new ArrayList<>();
        headerlist.add("Content-Type");
        headerlist.add(" Accept");
        headerlist.add("X-Requested-With");
        headerlist.add("Authorization");
        headers.setAccessControlAllowHeaders(headerlist);
        exposeList.add("Authorization");
        headers.setAccessControlExposeHeaders(exposeList);
        headers.set("Authorization", token);
        
        JwtDTO response = new JwtDTO();
        
        response.setAccessToken(token);
        response.setUsername(user.getUsername());
        
        
        return new ResponseEntity<JwtDTO>(response, HttpStatus.CREATED);
	}
	
    @PostMapping("/signout")
    @ResponseBody
    public ResponseEntity<String> logout (@RequestHeader(value="Authorization") String token) {
        HttpHeaders headers = new HttpHeaders();
      if (loginService.logout(token)) {
          headers.remove("Authorization");
          return new ResponseEntity<String>("Signed out.", headers, HttpStatus.CREATED);
      }
        return new ResponseEntity<String>("Logout failed", headers, HttpStatus.NOT_MODIFIED);
    }
    
    @PostMapping("/valid/token")
    @ResponseBody
    public Boolean isValidToken (@RequestHeader(value="Authorization") String token) {
        return true;
    }


    @PostMapping("/signin/token")
    @CrossOrigin("*")
    @ResponseBody
    public ResponseEntity<String> createNewToken (@RequestHeader(value="Authorization") String token) {
        String newToken = loginService.createNewToken(token);
        HttpHeaders headers = new HttpHeaders();
        List<String> headerList = new ArrayList<>();
        List<String> exposeList = new ArrayList<>();
        headerList.add("Content-Type");
        headerList.add(" Accept");
        headerList.add("X-Requested-With");
        headerList.add("Authorization");
        headers.setAccessControlAllowHeaders(headerList);
        exposeList.add("Authorization");
        headers.setAccessControlExposeHeaders(exposeList);
        headers.set("Authorization", newToken);
        return new ResponseEntity<String>(newToken, headers, HttpStatus.CREATED);
    }
    
	@RequestMapping(value = "/findLogged", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> findLogged() {
		return loginService.findLoggedInUsername();
	}
	
	
	
	

}
