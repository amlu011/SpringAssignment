package com.thoughtclan.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="organisation_facility")
public class OrganisationFacility {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int courtId;
	
	private String courtName;
	
	private String type;
	
	@OneToMany
	@JoinColumn(name="courtId" ,referencedColumnName="courtId")
	private List<SlotMapping> slotMapping ;
	
	
	public List<SlotMapping> getSlotMapping() {
		return slotMapping;
	}



	public void setSlotMapping(List<SlotMapping> slotMapping) {
		this.slotMapping = slotMapping;
	}



	@OneToMany(mappedBy="courtId")
	private List<CourtBooking> courtMap;
	
	public List<CourtBooking> getCourtMap() {
		return courtMap;
	}



	public void setCourtMap(List<CourtBooking> courtMap) {
		this.courtMap = courtMap;
	}



	@ManyToOne
	@JoinColumn(name="orgId" ,referencedColumnName="orgId")
	private Organisation orgId;



	public int getCourtId() {
		return courtId;
	}



	public void setCourtId(int courtId) {
		this.courtId = courtId;
	}



	public String getCourtName() {
		return courtName;
	}



	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public Organisation getOrgId() {
		return orgId;
	}



	public void setOrgId(Organisation orgId) {
		this.orgId = orgId;
	}



	


	
	

}
