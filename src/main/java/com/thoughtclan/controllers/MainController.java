package com.thoughtclan.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.thoughtclan.services.CourtBookingService;
import com.thoughtclan.services.OrganisationFacilityService;
import com.thoughtclan.services.SlotMappingService;
import com.thoughtclan.services.SportsService;
import com.thoughtclan.services.UserService;


@Controller
public class MainController {
	
	
	@Autowired
	private SportsService sportsService;
	
	@Autowired
	private OrganisationFacilityService organisationFacilityService;
	
	@Autowired
	private CourtBookingService courtBookingService;
	
	@Autowired
	private SlotMappingService slotMappingService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/")
	public ModelAndView loginSignUp() {
		ModelAndView modelAndView = new ModelAndView("LoginSignUpPage");
		return modelAndView;
		
	}
	
	@RequestMapping(value="/enterUser")
	public ModelAndView bookSlot() {
		
		
		ModelAndView modelAndView = new ModelAndView("welcome_user");
		modelAndView.addObject("user", new User());
		
		return modelAndView;
	
	}
	@RequestMapping(value="/enterLoginDetail")
	public ModelAndView loginDetail() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
		
	}
	
	
	
	@RequestMapping(value="/form",method=RequestMethod.POST)
	public ModelAndView getForm(@ModelAttribute(value="user") User user,HttpSession session, HttpServletRequest request) {
		boolean flag;
		flag=userService.addUser(user);
		if(flag==true) {
		ModelAndView modelAndView = new ModelAndView("welcome");
		
		String userEmail=user.getUserEmail();
		modelAndView.addObject("userEmail", userEmail);
		request.getSession().setAttribute("userSession", userEmail);
		
		modelAndView.addObject("userName", user.getUserName());
		return modelAndView;
		}
		else
		{
			ModelAndView modelAndView = new ModelAndView("tryAgain");
			return modelAndView;
		}
	}
	
	@RequestMapping(value="/loginForm")
	public ModelAndView getLogin(@RequestParam("userEmail")String userEmail,@RequestParam("userName")String userName,HttpSession session, HttpServletRequest request) {
		boolean flag;
		flag=userService.findUser(userEmail,userName);
		if(flag==true) {
		ModelAndView modelAndView = new ModelAndView("welcome");
		
		request.getSession().setAttribute("userSession", userEmail);
		modelAndView.addObject("userEmail", userEmail);
		modelAndView.addObject("userName",userName);
		return modelAndView;}
		else
		{
			System.out.println("+++++++++++++++++++++++++++");
			ModelAndView modelAndView = new ModelAndView("tryAgain");
			return modelAndView;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/processform")
	public ModelAndView processForm(@RequestParam("game")String game, @RequestParam("locality")String locality,HttpSession session, HttpServletRequest request) {
		
		
		 
		
		//request.getSession().setAttribute("userSession", userEmail);
		
		if(request.getSession().getAttribute("userSession")!=null) {
		
		List<OrganisationFacility> courts=organisationFacilityService.findCourtName(game,locality);
		
		
		ModelAndView modelAndView = new ModelAndView("select_court");
		
		modelAndView.addObject("courts", courts);
		
		
		return modelAndView;
		}
		else {
			return new ModelAndView("redirect:/");
	}
	}
	
	
	
	
	
	@GetMapping(value="/bookSlot")
	public ModelAndView bookCourt(@RequestParam("idchecked")Integer courtId,@RequestParam("date")String date,HttpSession session, HttpServletRequest request){
		
		
		
		OrganisationFacility facility=organisationFacilityService.findByCourtId(courtId);
		List<SlotMapping> slotMapping=slotMappingService.findSlot(courtId,date);
		
		if(request.getSession().getAttribute("userSession")!=null) {
		String s = (String)request.getSession().getAttribute("userSession");
		
		ModelAndView modelAndView = new ModelAndView("slot_booking");
		modelAndView.addObject("slotMapping",slotMapping);
		modelAndView.addObject("facility", facility);
		modelAndView.addObject("date",date);
		
		
		return modelAndView;
		}
		else
		{
			return new ModelAndView("redirect:/");
		}
	}
	
	
	@GetMapping(value="/bookCourt")
	public ModelAndView bookCourt(@RequestParam("slotMap")String slotId, @RequestParam("date")String date,@RequestParam("idChecked")Integer courtId,HttpSession session, HttpServletRequest request){
		
		
		if(request.getSession().getAttribute("userSession")!=null) {
		String s = (String)request.getSession().getAttribute("userSession");
		courtBookingService.addCourtBooking(slotId,courtId,date,s);
		List<CourtBooking> booking=courtBookingService.findBooking(s);
		
		ModelAndView modelAndView=new ModelAndView("show_booking");
		
		modelAndView.addObject("booking",booking);
		return modelAndView;
		}
		else {
			return new ModelAndView("redirect:/");
		
			
		}
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logut(HttpSession session, HttpServletResponse response) {
		session.invalidate();
		try {
			response.sendRedirect("/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}



