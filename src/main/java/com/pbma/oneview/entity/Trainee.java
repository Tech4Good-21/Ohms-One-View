package com.pbma.oneview.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
	@Column(name = "id")
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

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "training", referencedColumnName = "training_id")
	private Training training;

	@Override
	public String toString() {
		return "Trainee [id=" + id + ", name=" + name + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", idType=" + idType + ", idNumber=" + idNumber + ", married=" + married + ", email=" + email
				+ ", address=" + address + ", district=" + district + ", state=" + state + ", pin=" + pin
				+ ", training=" + training + ", familyInfo=" + familyInfo + ", traineeDetails=" + traineeDetails
				+ ", assessment=" + assessment + ", placement=" + placement + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public Integer getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(Integer idNumber) {
		this.idNumber = idNumber;
	}

	public Boolean getMarried() {
		return married;
	}

	public void setMarried(Boolean married) {
		this.married = married;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	public FamilyBackground getFamilyInfo() {
		return familyInfo;
	}

	public void setFamilyInfo(FamilyBackground familyInfo) {
		this.familyInfo = familyInfo;
	}

	public TraineeDetails getTraineeDetails() {
		return traineeDetails;
	}

	public void setTraineeDetails(TraineeDetails traineeDetails) {
		this.traineeDetails = traineeDetails;
	}

	public AssessmentDetails getAssessment() {
		return assessment;
	}

	public void setAssessment(AssessmentDetails assessment) {
		this.assessment = assessment;
	}

	public PlacementDetails getPlacement() {
		return placement;
	}

	public void setPlacement(PlacementDetails placement) {
		this.placement = placement;
	}

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "family_info", referencedColumnName = "family_id")
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