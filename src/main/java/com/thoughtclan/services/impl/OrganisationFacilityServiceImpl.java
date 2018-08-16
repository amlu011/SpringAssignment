package com.thoughtclan.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtclan.dao.SportsRepositoryCourt;
import com.thoughtclan.models.OrganisationFacility;
import com.thoughtclan.services.OrganisationFacilityService;

@Service
public class OrganisationFacilityServiceImpl implements OrganisationFacilityService {

	@Autowired
	private SportsRepositoryCourt sportsRepositoryCourt;
	
	
	/**
	 * finds all the courts present in the particular locality
	 */
	@Override
	public List<OrganisationFacility> findCourtName(String type,String locality){
		List<OrganisationFacility> courts =new ArrayList<>();


		//Iterable<Organisation> allorgs = sportsRepository.findAll();
		Iterable<OrganisationFacility> allcourts = sportsRepositoryCourt.findAll();


		for(OrganisationFacility c:allcourts )
		{
			if(c.getType().equals(type) && c.getOrgId().getOrgLocality().equals(locality)&&(c.getOrgId().getOrgId()==c.getOrgId().getOrgId()))
			{
				

				courts.add(c);
				

			}
		}

		return courts;

	}
	
	
	/**
	 * returns the court which matches the court id parameter
	 */
	@Override
	public OrganisationFacility findByCourtId(Integer courtId) {


		OrganisationFacility facility=new OrganisationFacility();
		facility=sportsRepositoryCourt.findById(courtId).get();
		return facility;

	}
}
