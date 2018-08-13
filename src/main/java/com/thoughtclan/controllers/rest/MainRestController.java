package com.thoughtclan.controllers.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtclan.models.Organisation;
import com.thoughtclan.services.SportsService;

@RestController
public class MainRestController {
	
	
	@Autowired
	private SportsService sportsService;



	@GetMapping("/findAllOrgs")
	public Collection<Organisation> findAllOrgs(){
		return sportsService.findAllOrgs();
	}

}



