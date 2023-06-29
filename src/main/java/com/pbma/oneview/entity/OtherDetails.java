package com.pbma.oneview.entity;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "OtherDetails")
@AllArgsConstructor
@NoArgsConstructor
public class OtherDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String highestEducation;
	private Boolean currentlyStudying;
	private Boolean technicalEducation;
	private String nameOfEducationInstitute;
	private String typeOfDisability;
	private Boolean pwdCertificate;
	private String casteCategory;

}