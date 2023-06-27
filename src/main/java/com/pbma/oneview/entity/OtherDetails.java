package com.pbma.oneview.entity;

import jakarta.persistence.Entity;

@Entity
@Data
public class OtherDetails {
	
	private String highestEducation;
	private Boolean currentlyStudying;
	private Boolean technicalEducation;
	private String nameOfEducationInstitute;
	private String typeOfDisability;
	private Boolean pwdCertificate;
	private String casteCategory;

}