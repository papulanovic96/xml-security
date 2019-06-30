package com.megatravel.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.megatravel.exception.ExceptionResponse;
import com.megatravel.model.EndUser;
import com.megatravel.model.JwtToken;
import com.megatravel.model.Role;
import com.megatravel.model.User;
import com.megatravel.security.JwtTokenProvider;

@Service
public class LoginService implements LoginInterface {
	@Autowired
    private PasswordEncoder passwordEncoder;
	
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private MicroService microService;

    @Override
    public String login(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
                    password));
            
            EndUser user = microService.findEndUser(username);
            		
            if (user == null || user.getRoles() == null || user.getRoles().isEmpty()) {
                throw new ExceptionResponse("Invalid username or password.", HttpStatus.UNAUTHORIZED);
            }
            //NOTE: normally we dont need to add "ROLE_" prefix. Spring does automatically for us.
            //Since we are using custom token using JWT we should add ROLE_ prefix
            String token =  jwtTokenProvider.createToken(username, user.getRoles().stream()
                    .map((Role role)-> "ROLE_"+role.getName().name()).filter(Objects::nonNull).collect(Collectors.toList()));
            return token;

        } catch (AuthenticationException e) {
            throw new ExceptionResponse("Invalid username or password." + " " + username + " " + password , HttpStatus.UNAUTHORIZED);
            
        }
    }

    @Override
    public ResponseEntity<String> saveUser(EndUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()) );
        return microService.saveEndUser(user);
    }

    @Override
    public boolean logout(String token) {
         microService.deleteToken(new JwtToken(token));
         return true;
    }

    @Override
    public Boolean isValidToken(String token) {
        return jwtTokenProvider.validateToken(token);
    }

    @Override
    public String createNewToken(String token) {
        String username = jwtTokenProvider.getUsername(token);
        List<String>roleList = jwtTokenProvider.getRoleList(token);
        String newToken =  jwtTokenProvider.createToken(username,roleList);
        return newToken;
    }

    @Override
	public ResponseEntity<String> findLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    return ResponseEntity.ok(currentUserName);
		}

		return new ResponseEntity<String>("Unauthorized request!", HttpStatus.UNAUTHORIZED);

	}

}
