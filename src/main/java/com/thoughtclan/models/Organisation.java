package com.thoughtclan.models;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="organisation")
public class Organisation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orgId;
	
	private String orgName;
	
	private String orgLocality;

	

	
	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgLocality() {
		return orgLocality;
	}

	public void setOrgLocality(String orgLocality) {
		this.orgLocality = orgLocality;
	}
	
	

}
