package com.pbma.oneview.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "Trainee")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Trainee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(referencedColumnName = "trainingId")
	private Training training;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(referencedColumnName = "familyId")
	private FamilyBackground familyInfo;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(referencedColumnName = "detailsId")
	private TraineeDetails traineeDetails;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(referencedColumnName = "assessmentId")
	private AssessmentDetails assessment;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(referencedColumnName = "placementId")
	private PlacementDetails placement;

}