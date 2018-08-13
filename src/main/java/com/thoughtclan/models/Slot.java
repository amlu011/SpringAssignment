package com.thoughtclan.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="slot_table")
public class Slot {
	
	@Id
	
	private String slotId;
	
	private String slotTiming;

	public String getSlotId() {
		return slotId;
	}
	
	

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public String getSlotTiming() {
		return slotTiming;
	}

	public void setSlotTiming(String slotTiming) {
		this.slotTiming = slotTiming;
	}
	
	

}
