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
public class AssessmentDetails {
	
	private Integer id;
	private String trainingStatus;
	private double attendance;
	private Boolean assessmentConducted;
	private Boolean certified;
	private LocalDate dateOfPassing;
	private LocalDate dateOfCertification;
	private String certificateName;
	private double grade;
	
}