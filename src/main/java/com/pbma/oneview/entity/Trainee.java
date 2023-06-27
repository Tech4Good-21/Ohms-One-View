package com.pbma.oneview.entity;

import java.time.LocalDate;

import com.pbma.oneview.pojo.AssessmentDetails;
import com.pbma.oneview.pojo.FamilyBackground;
import com.pbma.oneview.pojo.PlacementDetails;
import com.pbma.oneview.pojo.Training;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
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