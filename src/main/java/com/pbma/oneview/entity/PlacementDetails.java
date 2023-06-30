package com.pbma.oneview.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "")
@AllArgsConstructor
@NoArgsConstructor class PlacementDetails {
	
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