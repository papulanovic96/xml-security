package com.megatravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.megatravel.model.PriceInSeason;


public interface PriceInSeasonRepository extends JpaRepository<PriceInSeason, Long>{

	@Query(value = "select agentlocalbase.price_in_season.id, currency, in_month, price from" + 
			" agentlocalbase.price_in_season join agentlocalbase.accommodation_price_in_season on" + 
			" agentlocalbase.price_in_season.id = agentlocalbase.accommodation_price_in_season.price_in_season_id" + 
			" where agentlocalbase.accommodation_price_in_season.accommodation_id = ?1", nativeQuery = true)
	List<PriceInSeason> getPriceInSeason(long accId);
	
}
