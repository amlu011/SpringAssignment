package com.thoughtclan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thoughtclan.models.CourtBooking;

@Repository
public interface SportsRepositoryBooking extends CrudRepository<CourtBooking, Integer>{

	List<CourtBooking> findByUserUserEmail(String userEmail);
	
//	@Query("SELECT u FROM CourtBooking AS u WHERE u.user.userEmail= :email") 
//	List<CourtBooking> findbyemail(@Param("email") String email);

}
