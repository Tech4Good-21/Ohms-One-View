package com.pbma.oneview.entity;

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
public class OtherDetails {
	
	private String highestEducation;
	private Boolean currentlyStudying;
	private Boolean technicalEducation;
	private String nameOfEducationInstitute;
	private String typeOfDisability;
	private Boolean pwdCertificate;
	private String casteCategory;

}