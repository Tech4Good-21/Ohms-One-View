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
	@Column(name = "training_id")
	public Integer trainingId;

	@Column(name = "training_name")
	private String trainingName;

	@Column(name = "training_address")
	private String trainingAddress;

	@Column(name = "training_location")
	private String trainingLocation;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "batch", referencedColumnName = "batch_id")
	private Batch batch;


	
}