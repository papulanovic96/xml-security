package com.megatravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.megatravel.model.JwtToken;

@Repository
public interface JwtTokenRepository extends JpaRepository<JwtToken, String> {

	@Query(value = "select * from booking.jwt_token where booking.jwt_token.token = '?1'", nativeQuery = true)
	JwtToken findByToken(String token);
	
	
}
