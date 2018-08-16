package com.thoughtclan.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thoughtclan.models.CourtBooking;


public interface CourtBookingService {
	public void addCourtBooking(String slotId, Integer courtId,String date,String userEmail);
	public List<CourtBooking> findBooking(String userEmail);
}
