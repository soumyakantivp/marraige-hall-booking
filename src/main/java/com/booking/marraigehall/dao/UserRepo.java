package com.booking.marraigehall.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.marraigehall.model.User;

public interface UserRepo  extends JpaRepository<User, Integer>{
	Optional<User> findByusername(String username);
}
