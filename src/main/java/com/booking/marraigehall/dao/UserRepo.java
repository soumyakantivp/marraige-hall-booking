package com.booking.marraigehall.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.marraigehall.model.Users;

public interface UserRepo  extends JpaRepository<Users, Integer>{
	Optional<Users> findByusername(String username);
}
