package com.thoughtclan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thoughtclan.models.Organisation;

@Repository
public interface SportsRepository extends CrudRepository<Organisation,Integer>{

}
