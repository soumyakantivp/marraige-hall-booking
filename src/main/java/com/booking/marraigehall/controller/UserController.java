package com.booking.marraigehall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
}
