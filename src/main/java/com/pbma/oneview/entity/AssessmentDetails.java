package com.pbma.oneview.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;

@Entity
@Data
public class AssessmentDetails {
	
	private Integer id;
	private String trainingStatus;
	private double attendance;
	private boolean assessmentConducted;
	private boolean certified;
	private LocalDate dateOfPassing;
	private LocalDate dateOfCertification;
	private String certificateName;
	private double grade;
	
}