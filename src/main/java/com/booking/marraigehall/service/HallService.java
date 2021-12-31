package com.booking.marraigehall.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.marraigehall.dao.HallRepo;
import com.booking.marraigehall.model.Hall;

@Service
public class HallService {
	
	@Autowired
	HallRepo repo;
	
	public List<Hall> getHalls() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public List<Hall> getHallsByCity(String city) {
		// TODO Auto-generated method stub
		return repo.findByCity(city);
	}

	public void addHall(Hall newHall) {
		repo.save(newHall);
	}

	public Optional<Hall> getHallById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}
}
