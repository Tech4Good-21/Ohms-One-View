package com.pbma.oneview.entity;

import jakarta.persistence.Entity;

@Entity
@Data
public class FamilyBackground {
	
	private String guardianType;
	private String nameOfGuardian;
	private Integer familyMemberCount;
	private String familyEcoStatus;
	private Integer familyIncome;
	private String sourceOfIncome;
	private Integer personalIncome;
	
}