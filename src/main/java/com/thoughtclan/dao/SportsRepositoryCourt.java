package com.thoughtclan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thoughtclan.models.OrganisationFacility;

@Repository
public interface SportsRepositoryCourt extends CrudRepository<OrganisationFacility,Integer>{

}
