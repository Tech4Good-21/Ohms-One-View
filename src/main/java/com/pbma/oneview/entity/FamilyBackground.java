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
	private Long familyId;
	private String guardianType;
	private String nameOfGuardian;
	private Integer familyMemberCount;
	private String familyEcoStatus;
	private Integer familyIncome;
	private String sourceOfIncome;
	private Integer personalIncome;
	
}