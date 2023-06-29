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
@Table(name = "AssessmentDetails")
@AllArgsConstructor
@NoArgsConstructor
public class AssessmentDetails {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String trainingStatus;
	private double attendance;
	private Boolean assessmentConducted;
	private Boolean certified;
	private LocalDate dateOfPassing;
	private LocalDate dateOfCertification;
	private String certificateName;
	private double grade;
	
}