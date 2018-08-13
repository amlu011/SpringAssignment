package com.thoughtclan.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtclan.dao.SportsRepository;
import com.thoughtclan.dao.SportsRepositoryBooking;
import com.thoughtclan.dao.SportsRepositoryCourt;
import com.thoughtclan.dao.SportsRepositorySlotMapping;
import com.thoughtclan.dao.SportsRepositoryUser;
import com.thoughtclan.models.CourtBooking;
import com.thoughtclan.models.Organisation;
import com.thoughtclan.models.OrganisationFacility;
import com.thoughtclan.models.SlotMapping;
import com.thoughtclan.models.User;


@Service
@Transactional
public class SportsService {

	@Autowired
	private SportsRepository sportsRepository;

	@Autowired
	private SportsRepositoryBooking sportsRepositoryBooking;

	@Autowired
	private SportsRepositorySlotMapping sportsRepositorySlotMapping;
	@Autowired
	private SportsRepositoryCourt sportsRepositoryCourt;
	@Autowired
	private SportsRepositoryUser sportsRepositoryUser;


	public Collection<Organisation> findAllOrgs(){

		List<Organisation> courts =new ArrayList<Organisation>();
		for(Organisation org:sportsRepository.findAll() ) {

			courts.add(org);
		}
		return courts;



	}




	public List<OrganisationFacility> findCourtName(String type,String locality){
		List<OrganisationFacility> courts =new ArrayList<>();


		//Iterable<Organisation> allorgs = sportsRepository.findAll();
		Iterable<OrganisationFacility> allcourts = sportsRepositoryCourt.findAll();


		for(OrganisationFacility c:allcourts )
		{
			if(c.getType().equals(type) && c.getOrgId().getOrgLocality().equals(locality)&&(c.getOrgId().getOrgId()==c.getOrgId().getOrgId()))
			{
				

				courts.add(c);
				System.out.println(c.getCourtName());

			}
		}

		return courts;

	}






	public void addUser(User user) {
		sportsRepositoryUser.save(user);


	}




	public OrganisationFacility findByCourtId(Integer courtId) {


		OrganisationFacility facility=new OrganisationFacility();
		facility=sportsRepositoryCourt.findById(courtId).get();
		return facility;

	}



	public List<SlotMapping> findSlot(Integer courtId,String date){
		OrganisationFacility courts =new OrganisationFacility();

		List<SlotMapping> availableSlots=new ArrayList<>();
		//Iterable<Organisation> allorgs = sportsRepository.findAll();
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




	public List<CourtBooking> findBooking(String userEmail) {
		System.out.println("inside method");
		
		List<CourtBooking> booking=sportsRepositoryBooking.findByUserUserEmail(userEmail);
		return booking;
		
		
		
	}

}
