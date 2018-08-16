package com.thoughtclan.services;

import java.util.List;

import com.thoughtclan.models.OrganisationFacility;

public interface OrganisationFacilityService {
	public List<OrganisationFacility> findCourtName(String type,String locality);
	public OrganisationFacility findByCourtId(Integer courtId);

}
