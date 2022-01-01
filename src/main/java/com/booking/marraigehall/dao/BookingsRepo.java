package com.booking.marraigehall.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.marraigehall.model.Bookings;

public interface BookingsRepo extends JpaRepository<Bookings, Integer>{

}
