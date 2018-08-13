package com.thoughtclan.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.thoughtclan.models.CourtBooking;
import com.thoughtclan.models.OrganisationFacility;
import com.thoughtclan.models.SlotMapping;
import com.thoughtclan.models.User;

import com.thoughtclan.services.SportsService;


@Controller
public class MainController {
	
	
	@Autowired
	private SportsService sportsService;
		
	@RequestMapping(value="/")
	public ModelAndView bookSlot() {
		
		
		ModelAndView modelAndView = new ModelAndView("welcome_user");
		modelAndView.addObject("user", new User());
		
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/form",method=RequestMethod.POST)
	public ModelAndView getForm(@ModelAttribute(value="user") User user) {
		
		sportsService.addUser(user);
		ModelAndView modelAndView = new ModelAndView("welcome");
		String userEmail=user.getUserEmail();
		modelAndView.addObject("userEmail", userEmail);
		modelAndView.addObject("userName", user.getUserName());
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value="/processform",method=RequestMethod.POST)
	public ModelAndView processForm(@RequestParam("userEmail")String userEmail,@RequestParam("game")String game, @RequestParam("locality")String locality) {
		
		
		 
		List<OrganisationFacility> courts =new ArrayList<>();
		
		
		
		courts=sportsService.findCourtName(game,locality);
		
		
		ModelAndView modelAndView = new ModelAndView("select_court");
		
		modelAndView.addObject("courts", courts);
		modelAndView.addObject("userEmail", userEmail);
		
		return modelAndView;
		
	}
	
	
	
	
	
	@GetMapping(value="/bookSlot")
	public ModelAndView bookCourt(@RequestParam("userEmail")String userEmail,@RequestParam("idchecked")Integer courtId,@RequestParam("date")String date){
		
		
		OrganisationFacility facility=sportsService.findByCourtId(courtId);
		List<SlotMapping> slotMapping=sportsService.findSlot(courtId,date);
		
		
		ModelAndView modelAndView = new ModelAndView("slot_booking");
		modelAndView.addObject("slotMapping",slotMapping);
		modelAndView.addObject("facility", facility);
		modelAndView.addObject("date",date);
		modelAndView.addObject("userEmail", userEmail);
		
		return modelAndView;
	}
	
	
	@GetMapping(value="/bookCourt")
	public ModelAndView bookCourt(@RequestParam("userEmail")String userEmail,@RequestParam("slotMap")String slotId, @RequestParam("date")String date,@RequestParam("idChecked")Integer courtId){
		
		
		

		sportsService.addCourtBooking(slotId,courtId,date,userEmail);
		List<CourtBooking> booking=sportsService.findBooking(userEmail);
		System.out.println(userEmail);
		ModelAndView modelAndView=new ModelAndView("show_booking");
		
		modelAndView.addObject("booking",booking);
		return modelAndView;
		
	}
	
}



