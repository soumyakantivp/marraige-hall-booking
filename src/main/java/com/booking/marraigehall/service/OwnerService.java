package com.booking.marraigehall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.marraigehall.dao.HallRepo;
import com.booking.marraigehall.model.Hall;

@Service
public class OwnerService {
	
	@Autowired
	HallRepo hall_repo;
	
	public List<Hall> getMyHalls(int loggedInUserId) {
		// TODO Auto-generated method stub
		return hall_repo.findByOwner(loggedInUserId);
	}
	
}
