package com.pbma.oneview.entity;

import jakarta.persistence.Entity;

@Entity
@Data
public class Training {

	public Integer trainingId;
	private String trainingName;
	private String trainingAddress;
	private String trainingLocation;
	private Batch batch;
	
}