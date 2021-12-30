package com.booking.marraigehall.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.marraigehall.dao.UserRepo;
import com.booking.marraigehall.model.Users;

@Service
public class UserService {
	
	@Autowired
	UserRepo repo;

	public boolean addUser(Users newUser) {
		// TODO Auto-generated method stub
		if(repo.findByusername(newUser.getUsername()).equals(Optional.empty())) {
			repo.save(newUser);
			return true;
		}
		return false;
	}
	
	
}
