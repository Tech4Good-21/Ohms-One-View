package com.pbma.oneview.entity;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "Training")
@AllArgsConstructor
@NoArgsConstructor
public class Training {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer trainingId;
	private String trainingName;
	private String trainingAddress;
	private String trainingLocation;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "batchId")
	private Batch batch;
	
}