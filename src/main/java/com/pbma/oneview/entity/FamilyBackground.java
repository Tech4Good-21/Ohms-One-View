package com.pbma.oneview.entity;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "FamilyBackground")
@AllArgsConstructor
@NoArgsConstructor
public class FamilyBackground {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "family_id")
	private Long familyId;

	@Column(name = "guardian_type")
	private String guardianType;

	@Column(name = "name_of_guardian")
	private String nameOfGuardian;

	@Column(name = "family_member_count")
	private Integer familyMemberCount;

	@Column(name = "family_eco_status")
	private String familyEcoStatus;

	@Column(name = "family_income")
	private Integer familyIncome;

	@Column(name = "source_of_income")
	private String sourceOfIncome;

	@Column(name = "personal_income")
	private Integer personalIncome;

}