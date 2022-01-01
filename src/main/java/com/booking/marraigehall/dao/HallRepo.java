package com.booking.marraigehall.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.marraigehall.model.Hall;

@Repository
public interface HallRepo extends JpaRepository<Hall, Integer>{

	List<Hall> findByCity(String city);
	
	List<Hall> findByOwner(int owner);
}