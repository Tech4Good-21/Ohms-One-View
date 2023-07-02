package com.pbma.oneview.entity;

import java.time.LocalDate;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Pattern.Flag;

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
	
	@Column(name = "name")
	@NotBlank
	private String name;

	@Column(name = "gender")
	@NotBlank
	private String gender;

	@Column(name = "date_of_birth")
	@Past
	@NotBlank
	private LocalDate dateOfBirth;

	@Column(name = "id_type")
	@NotBlank
	private String idType;

	@Column(name = "id_number")
	@NotBlank
	private Integer idNumber;

	@Column(name = "married")
	@NotBlank
	private Boolean married;

	@Column(name = "email") 
	@Email(message = "The email address is invalid.", flags = { Flag.CASE_INSENSITIVE })
	private String email;

	@Column(name = "address")
	@NotBlank
	private String address;

	@Column(name = "district")
	@NotBlank
	private String district;

	@Column(name = "state")
	@NotBlank
	private String state;

	@Column(name = "pin")
	@Pattern(regexp = "\\d{6}", message = "Invalid Pincode")
	private Integer pin;

	@OneToOne
	@JoinColumn(referencedColumnName = "trainingId")
	private Training training;

	@OneToOne
	@JoinColumn(referencedColumnName = "familyId")
	private FamilyBackground familyInfo;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "trainee_details", referencedColumnName = "details_id")
	private TraineeDetails traineeDetails;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "assessment", referencedColumnName = "assessment_id")
	private AssessmentDetails assessment;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "placement", referencedColumnName = "placement_id")
	private PlacementDetails placement;

}