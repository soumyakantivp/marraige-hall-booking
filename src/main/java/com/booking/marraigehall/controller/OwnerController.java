package com.booking.marraigehall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.marraigehall.model.Hall;
import com.booking.marraigehall.service.HallService;

@Controller
public class OwnerController {
	@Autowired
	HallService hall_service;
	
	@RequestMapping(value = "/owner-dashboard/add-hall",method =RequestMethod.POST)
	public String createNewHall( @RequestParam("name")String name, @RequestParam("city")String city, @RequestParam("area")double area,@RequestParam("image")String image, @RequestParam("price")double price, @RequestParam("discount")double discount){
		city = city.toLowerCase();
		Hall newHall = new Hall(name, city, area, image, price, discount);
		hall_service.addHall(newHall);
		System.out.println(newHall);
		
		return "owner";
	}
	
	@RequestMapping(value = "/owner-dashboard",method =RequestMethod.GET)
	public String showOwnerDashboard(){
		//System.out.println("in");
		return "owner";
	}
}
