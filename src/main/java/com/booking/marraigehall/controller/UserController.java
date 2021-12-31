package com.booking.marraigehall.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.marraigehall.model.Hall;
import com.booking.marraigehall.model.Users;
import com.booking.marraigehall.service.HallService;
import com.booking.marraigehall.service.UserService;

@Controller
public class UserController {

	
	@Autowired
	UserService service;
	
	@Autowired
	HallService hall_service;
	
	
	@RequestMapping(value = "/register",method =RequestMethod.GET)
	public String getRegistrationForm(){
		return "register";
	}
	
	@RequestMapping(value = "/register",method =RequestMethod.POST)
	public String register(ModelMap model, @RequestParam("email")String email, @RequestParam("password")String password, @RequestParam("confirm")String confirm, @RequestParam("role")String role){
		System.out.println(email+" "+password+" "+confirm+" "+role);
		if(password.equals(confirm)) {
			Users newUser = new Users(email, password, true, role);
			if(service.addUser(newUser)) {
				model.addAttribute("name", email);
				return "reg-success";
			}
			else {
				model.addAttribute("err","user already registered!");
				return "reg-failure";
			}
		}
		model.addAttribute("err","password and confirmation are not same!");
		return "reg-failure";
	}
	
	
	
	@RequestMapping(value = "/book/{id}",method=RequestMethod.GET)
	public String bookHall(ModelMap model, @PathVariable int id){
		//System.out.println(id);
		Optional<Hall> hall = hall_service.getHallById(id);
		if(hall.isPresent()) {
			model.addAttribute("hall",hall.get());
			System.out.println(hall);
		}
		return "book-hall";
	}
	
	@RequestMapping(value = "/book/pay",method=RequestMethod.GET)
	public String bookHallDate(ModelMap model, @RequestParam("from")String from, @RequestParam("to")String to, @RequestParam("id")int id){
		System.out.println(from+" | "+to+" | "+id);
		Optional<Hall> hall = hall_service.getHallById(id);
		if(hall.isPresent()) {
			model.addAttribute("hall",hall.get());
			System.out.println(hall);
		}
		System.out.println(hall);
		return "buy-hall";
	}
	
}
