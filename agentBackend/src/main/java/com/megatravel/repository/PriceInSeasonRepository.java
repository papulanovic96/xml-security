package com.megatravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.megatravel.model.PriceInSeason;


public interface PriceInSeasonRepository extends JpaRepository<PriceInSeason, Long>{

	@Query(value = "select agentLocalBase.price_in_season.id, currency, in_month, price from agentlocalbase.price_in_season join agentlocalbase.accommodation "
			+ "on agentLocalBase.price_in_season.id = agentLocalBase.accommodation.price_in_season_id" + 
			  " where agentLocalBase.accommodation.id = ?1", nativeQuery = true)
	List<PriceInSeason> getPriceInSeason(long accId);
	
}
