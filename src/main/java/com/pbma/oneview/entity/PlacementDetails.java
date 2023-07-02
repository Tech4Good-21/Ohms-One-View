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
@Table(name = "PlacementDetails")
@AllArgsConstructor
@NoArgsConstructor class PlacementDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "placement_status")
	private String placementStatus;

	@Column(name = "date_of_placement")
	private LocalDate dateOfPlacement;

	@Column(name = "placement_sector")
	private String placementSector ;

	@Column(name = "job_role")
	private String jobRole;

	@Column(name = "employment_method")
	private String employmentMethod;

	@Column(name = "employer_name")
	private LocalDate employerName;

	@Column(name = "employer_contact_person")
	private String employerContactPerson;

	@Column(name = "contact_person_number")
	private String contactPersonNumber;

}