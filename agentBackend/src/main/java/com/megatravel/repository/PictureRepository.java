package com.megatravel.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.megatravel.model.Picture;



public interface PictureRepository extends JpaRepository<Picture, Long> {
	
	public Picture findOneById(long id);
}
