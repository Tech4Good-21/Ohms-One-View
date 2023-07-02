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
	@Column(name = "id")
	private Long id;
	
	@Column(name = "training_status")
	private String trainingStatus;
	
	@Column(name = "attendance")
	private double attendance;
	
	@Column(name = "assessment_conducted")
	private Boolean assessmentConducted;
	
	@Column(name = "certified")
	private Boolean certified;
	
	@Column(name = "date_of_passing")
	private LocalDate dateOfPassing;
	
	@Column(name = "date_of_certification")
	private LocalDate dateOfCertification;
	
	@Column(name = "certificate_name")
	private String certificateName;
	
	@Column(name = "grade")
	private double grade;
	
}