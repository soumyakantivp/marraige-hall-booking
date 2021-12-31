package com.booking.marraigehall.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.booking.marraigehall.model.Hall;
import com.booking.marraigehall.service.HallService;

@Controller
public class HallController {
	@Autowired
	HallService service;

	@RequestMapping(value = "/halls/all",method =RequestMethod.GET)
	public ModelAndView getHalls(){
		List<Hall> list = new ArrayList<Hall>();
		list = service.getHalls();
		//model.addAttribute("halls", list);
		//System.out.println(list);
		//return "index";
		ModelAndView mav = new ModelAndView("index");
		System.out.println(list);
		mav.addObject("halls", list);
		return mav;
	}

	@RequestMapping(value = "/halls",method =RequestMethod.GET)
	public ModelAndView getHalls(@RequestParam("city")String city){
		List<Hall> list = new ArrayList<Hall>();
		city = city.toLowerCase();
		list = service.getHallsByCity(city);
		//model.addAttribute("halls", list);
		//System.out.println(list);
		//return "index";

		ModelAndView mav = new ModelAndView("index");
		System.out.println(list);
		mav.addObject("halls", list);
		return mav;
	}

	@RequestMapping(value = "/halls/pricerange/{from}/{to}",method =RequestMethod.GET)
	public String getHalls(@PathVariable Double from,@PathVariable Double to){
		return "";
	}

	@RequestMapping(value = "/halls/sorted/price",method =RequestMethod.GET)
	public String getSortedHalls(){
		return "";
	}
}
