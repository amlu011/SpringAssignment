package com.thoughtclan.services;

import java.util.List;

import com.thoughtclan.models.SlotMapping;

public interface SlotMappingService {
	public List<SlotMapping> findSlot(Integer courtId,String date);
	
}
