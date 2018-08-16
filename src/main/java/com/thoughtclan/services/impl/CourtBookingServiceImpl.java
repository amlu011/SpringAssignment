package com.thoughtclan.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtclan.dao.SportsRepositoryBooking;
import com.thoughtclan.dao.SportsRepositoryCourt;
import com.thoughtclan.dao.SportsRepositorySlotMapping;
import com.thoughtclan.dao.SportsRepositoryUser;
import com.thoughtclan.models.CourtBooking;
import com.thoughtclan.models.OrganisationFacility;
import com.thoughtclan.models.SlotMapping;
import com.thoughtclan.models.User;
import com.thoughtclan.services.CourtBookingService;

@Service
public class CourtBookingServiceImpl implements CourtBookingService  {
	
	@Autowired
	private SportsRepositorySlotMapping sportsRepositorySlotMapping;
	
	@Autowired
	private SportsRepositoryUser sportsRepositoryUser;
	
	@Autowired
	private SportsRepositoryCourt sportsRepositoryCourt;
	
	@Autowired
	private SportsRepositoryBooking sportsRepositoryBooking;
	
	@Override
	public void addCourtBooking(String slotId, Integer courtId,String date,String userEmail) {
		CourtBooking booking=new CourtBooking();
		SlotMapping slotMap=sportsRepositorySlotMapping.findBySlotIdSlotIdAndCourtIdCourtId(slotId,courtId);
		OrganisationFacility court=sportsRepositoryCourt.findById(courtId).get();
		User user =sportsRepositoryUser.findById(userEmail).get();
		booking.setCourtId(court);
		booking.setSlotMapId(slotMap);
		booking.setDatee(date);
		booking.setUser(user);
		sportsRepositoryBooking.save(booking);


	}

	@Override
public List<CourtBooking> findBooking(String userEmail) {
		
		
		List<CourtBooking> booking=sportsRepositoryBooking.findByUserUserEmail(userEmail);
		return booking;
		
		
		
	}
}
