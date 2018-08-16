package com.thoughtclan.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * maps the slots with the court bookings
 * @author anushka
 *
 */

@Entity
public class SlotMapping {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name="slotId" ,referencedColumnName="slotId")
	private Slot slotId;
	
	@ManyToOne
	@JoinColumn(name="courtId" ,referencedColumnName="courtId")
	private OrganisationFacility courtId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Slot getSlotId() {
		return slotId;
	}

	public void setSlotId(Slot slotId) {
		this.slotId = slotId;
	}

	public OrganisationFacility getCourtId() {
		return courtId;
	}

	public void setCourtId(OrganisationFacility courtId) {
		this.courtId = courtId;
	}
	
	
	
}