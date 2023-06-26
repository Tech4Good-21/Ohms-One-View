package com.pbma.oneview.pojo;

import java.time.LocalDate;

public class PlacementDetails {
	private int id;
	private String placementStatus;
	private LocalDate dateOfPlacement;
	private String placementSector ;
	private String jobRole;
	private String employmentMethod;
	private LocalDate employerName;
	private String employerContactPerson;
	private String contactPersonNumber;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlacementStatus() {
		return placementStatus;
	}
	public void setPlacementStatus(String placementStatus) {
		this.placementStatus = placementStatus;
	}
	public LocalDate getDateOfPlacement() {
		return dateOfPlacement;
	}
	public void setDateOfPlacement(LocalDate dateOfPlacement) {
		this.dateOfPlacement = dateOfPlacement;
	}
	public String getPlacementSector() {
		return placementSector;
	}
	public void setPlacementSector(String placementSector) {
		this.placementSector = placementSector;
	}
	public String getJobRole() {
		return jobRole;
	}
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	public String getEmploymentMethod() {
		return employmentMethod;
	}
	public void setEmploymentMethod(String employmentMethod) {
		this.employmentMethod = employmentMethod;
	}
	public LocalDate getEmployerName() {
		return employerName;
	}
	public void setEmployerName(LocalDate employerName) {
		this.employerName = employerName;
	}
	public String getEmployerContactPerson() {
		return employerContactPerson;
	}
	public void setEmployerContactPerson(String employerContactPerson) {
		this.employerContactPerson = employerContactPerson;
	}
	public String getContactPersonNumber() {
		return contactPersonNumber;
	}
	public void setContactPersonNumber(String contactPersonNumber) {
		this.contactPersonNumber = contactPersonNumber;
	}
}
