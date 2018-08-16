package com.thoughtclan.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtclan.dao.SportsRepositoryCourt;
import com.thoughtclan.models.CourtBooking;
import com.thoughtclan.models.OrganisationFacility;
import com.thoughtclan.models.SlotMapping;
import com.thoughtclan.services.SlotMappingService;

@Service
public class SlotMappingServiceImpl implements SlotMappingService {
	
	@Autowired
	private SportsRepositoryCourt sportsRepositoryCourt;
	
	@Override
	public List<SlotMapping> findSlot(Integer courtId,String date){
		OrganisationFacility courts =new OrganisationFacility();

		List<SlotMapping> availableSlots=new ArrayList<>();
		
		Iterable<OrganisationFacility> allcourts = sportsRepositoryCourt.findAll();


		for(OrganisationFacility c:allcourts )
		{
			if(c.getCourtId()==courtId)
			{
				List<SlotMapping> allSlotList=c.getSlotMapping();

				List<SlotMapping> bookedSlotsList=new ArrayList<>();


				for(CourtBooking courtBooking:c.getCourtMap() )
				{
				
					if(courtBooking.getDatee().equals(date)) {
					bookedSlotsList.add(courtBooking.getSlotMapId());
					}
				}

				
				for(SlotMapping slot: allSlotList ) {
					
					if(!bookedSlotsList.contains(slot)) {

						availableSlots.add(slot);

					}
				}
				
			}
		}

		return availableSlots;

	}

}
