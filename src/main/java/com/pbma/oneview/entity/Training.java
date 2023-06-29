package com.pbma.oneview.entity;

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
public class Training {

	public Integer trainingId;
	private String trainingName;
	private String trainingAddress;
	private String trainingLocation;
	private Batch batch;
	
}