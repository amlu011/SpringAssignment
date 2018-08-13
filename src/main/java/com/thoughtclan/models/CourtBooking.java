package com.thoughtclan.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="court_booking")
public class CourtBooking {
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	
	
	
	@ManyToOne
	@JoinColumn(name="slotMapId",referencedColumnName="id")
	private SlotMapping slotMapId;
	
	@ManyToOne
	@JoinColumn(name="courtId",referencedColumnName="courtId")
	private OrganisationFacility courtId;


	public OrganisationFacility getCourtId() {
		return courtId;
	}

	public void setCourtId(OrganisationFacility courtId) {
		this.courtId = courtId;
	}

	public SlotMapping getSlotMapId() {
		return slotMapId;
	}

	public void setSlotMapId(SlotMapping slotMapId) {
		this.slotMapId = slotMapId;
	}

	
	
	private String datee;
	

	
	public String getDatee() {
		return datee;
	}

	public void setDatee(String datee) {
		this.datee = datee;
	}



	@ManyToOne
	@JoinColumn(name="userEmail",referencedColumnName="userEmail")
	private User user;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	
	
	

}
