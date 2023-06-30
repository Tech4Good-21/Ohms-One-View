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
@Table(name = "Trainee")
@AllArgsConstructor
@NoArgsConstructor
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

	@OneToOne
	@JoinColumn(referencedColumnName = "trainingId")
	private Training training;

	@OneToOne
	@JoinColumn(referencedColumnName = "familyId")
	private FamilyBackground familyInfo;

	@OneToOne
	@JoinColumn(referencedColumnName = "id")
	private OtherDetails otherDetails;

	@OneToOne
	@JoinColumn(referencedColumnName = "id")
	private AssessmentDetails assessment;

	@OneToOne
	@JoinColumn(referencedColumnName = "id")
	private PlacementDetails placement;

}