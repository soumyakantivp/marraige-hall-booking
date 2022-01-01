package com.booking.marraigehall.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.marraigehall.model.Hall;
import com.booking.marraigehall.security.CustomUserDetails;
import com.booking.marraigehall.service.HallService;
import com.booking.marraigehall.service.OwnerService;

@Controller
public class OwnerController {
	@Autowired
	HallService hall_service;
	
	@Autowired
	OwnerService owner_service;
	
	@RequestMapping(value = "/owner-dashboard/add-hall",method =RequestMethod.POST)
	public String createNewHall(ModelMap model, @RequestParam("name")String name, @RequestParam("city")String city, @RequestParam("area")double area,@RequestParam("image")String image, @RequestParam("price")double price, @RequestParam("discount")double discount){
		city = city.toLowerCase();
		Hall newHall = new Hall(name, city, area, image, price, discount, getLoggedInUserId(model));
		hall_service.addHall(newHall);
		System.out.println(newHall);
		
		return "redirect:/owner-dashboard";
	}
	
	@RequestMapping(value = "/owner-dashboard",method =RequestMethod.GET)
	public String showOwnerDashboard(ModelMap model){
		List<Hall> list = owner_service.getMyHalls(getLoggedInUserId(model));
		//System.out.println("in");
		model.addAttribute("halls", list);
		System.out.println(list);
		return "owner";
	}
	
	@RequestMapping(value = "/owner/update/{hall_id}",method =RequestMethod.GET)
	public String updateHall(ModelMap model, @PathVariable int hall_id){
		Optional<Hall> hall = hall_service.getHallById(hall_id);
		
		if(hall.isPresent()) {
			model.addAttribute("hall", hall.get());
			return "update-hall";
		}
		return "error";
	}
	
	@RequestMapping(value = "/owner/delete/{hall_id}",method =RequestMethod.GET)
	public String deleteHall(ModelMap model, @PathVariable int hall_id){
		hall_service.deleteById(hall_id);
		
		return "redirect:/owner-dashboard";
	}
	
	@RequestMapping(value = "/owner/update",method =RequestMethod.POST)
	public String updateHall(ModelMap model, @RequestParam("name")String name, @RequestParam("city")String city, @RequestParam("area")double area,@RequestParam("image")String image, @RequestParam("price")double price, @RequestParam("discount")double discount, @RequestParam("id")int id){
		city = city.toLowerCase();
		Hall newHall = new Hall(name, city, area, image, price, discount, getLoggedInUserId(model));
		hall_service.updateHall(id, newHall);
		//System.out.println(newHall);
		
		return "redirect:/owner-dashboard";
	}
	
	private int getLoggedInUserId(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof CustomUserDetails) {
			return ((CustomUserDetails) principal).getId();
		}
		System.out.println("loggedin userid: "+principal.toString());
		return -1;
	}
}
