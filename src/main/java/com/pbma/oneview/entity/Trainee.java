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
@NoArgsConstructor
public class Trainee {
	
	@Id
	private Integer id;
	private String name;
	private String gender;
	private LocalDate dob;
	private String idType;
	private Integer idNumber;
	private Boolean married;
	private String email;
	private String address;
	private String district;
	private String state;
	private Integer pin;
	private Training training;
	private FamilyBackground familyInfo;
	private OtherDetails otherDetails;
	private AssessmentDetails assessment;
	private PlacementDetails placement;

}