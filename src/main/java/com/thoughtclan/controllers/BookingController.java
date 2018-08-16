package com.thoughtclan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thoughtclan.models.CourtBooking;
import com.thoughtclan.services.CourtBookingService;
import com.thoughtclan.services.SportsService;

@Controller
public class BookingController {
	
	
	@Autowired
	private CourtBookingService courtBookingService;
	
	@RequestMapping(value="/enterEmail")
	public ModelAndView enterEmail() {
		ModelAndView modelAndView=new ModelAndView("view_booking_form");
		
		
		return modelAndView;
	}
	
	@RequestMapping(value="/viewBooking")
	public ModelAndView viewBooking(@RequestParam("email")String userEmail) {
		
		
		List<CourtBooking> booking=courtBookingService.findBooking(userEmail);
	
		ModelAndView modelAndView=new ModelAndView("show_booking");
		
		modelAndView.addObject("booking",booking);
		return modelAndView;
	}

}
