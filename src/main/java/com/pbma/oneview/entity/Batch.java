package com.pbma.oneview.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
@Data
public class Batch {
	
	private Integer id;
	private String course;
	private String sector;
	private LocalDate startDate;
	private LocalDate endDate;

}