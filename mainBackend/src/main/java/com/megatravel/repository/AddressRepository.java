package com.megatravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megatravel.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
