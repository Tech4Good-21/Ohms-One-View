package com.pbma.oneview.entity;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "TraineeDetails")
@AllArgsConstructor
@NoArgsConstructor
public class TraineeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "details_id")
	private Long detailsId;

	@Column(name = "highest_education")
	private String highestEducation;

	@Column(name = "currently_studying")
	private Boolean currentlyStudying;

	@Column(name = "technical_education")
	private Boolean technicalEducation;

	@Column(name = "name_of_education_institute")
	private String nameOfEducationInstitute;

	@Column(name = "type_of_disability")
	private String typeOfDisability;

	@Column(name = "pwd_certificate")
	private Boolean pwdCertificate;

	@Column(name = "caste_category")
	private String casteCategory;

}