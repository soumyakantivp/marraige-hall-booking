package com.booking.marraigehall.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.booking.marraigehall.model.Hall;

@Controller
public class HomeController {
	@RequestMapping(value = "/",method =RequestMethod.GET)
	public String getHalls(){
		return "index";
	}
}
