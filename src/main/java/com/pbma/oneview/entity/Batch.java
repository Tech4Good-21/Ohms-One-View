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
@Table(name = "Batch")
@AllArgsConstructor
@NoArgsConstructor
public class Batch {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long batchId;
	private String course;
	private String sector;
	private LocalDate startDate;
	private LocalDate endDate;

}