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
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "gender")
	private String gender;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(name = "id_type")
	private String idType;

	@Column(name = "id_number")
	private Integer idNumber;

	@Column(name = "married")
	private Boolean married;

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;

	@Column(name = "district")
	private String district;

	@Column(name = "state")
	private String state;

	@Column(name = "pin")
	private Integer pin;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "training", referencedColumnName = "training_id")
	private Training training;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "family_info", referencedColumnName = "family_id")
	private FamilyBackground familyInfo;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "trainee_details", referencedColumnName = "id")
	private TraineeDetails traineeDetails;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "assessment", referencedColumnName = "id")
	private AssessmentDetails assessment;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "placement", referencedColumnName = "id")
	private PlacementDetails placement;

}