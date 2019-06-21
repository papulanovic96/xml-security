package com.megatravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megatravel.model.Agent;

@Repository
public interface AdminAgentRepository extends JpaRepository<Agent, Long>{

}
