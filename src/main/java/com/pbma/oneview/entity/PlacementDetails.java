package com.pbma.oneview.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
@Data
public class PlacementDetails {
	
	private Integer id;
	private String placementStatus;
	private LocalDate dateOfPlacement;
	private String placementSector ;
	private String jobRole;
	private String employmentMethod;
	private LocalDate employerName;
	private String employerContactPerson;
	private String contactPersonNumber;

}