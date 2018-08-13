package com.thoughtclan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thoughtclan.models.SlotMapping;

@Repository
public interface SportsRepositorySlotMapping extends CrudRepository<SlotMapping,Integer> {

	 SlotMapping findBySlotIdSlotIdAndCourtIdCourtId(String slotId, Integer courtId);

}
