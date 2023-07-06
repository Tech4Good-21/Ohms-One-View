package com.pbma.oneview.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "training")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;

	@Column(name = "description", length = 250, nullable = false)
	private String description;

	@Column(name = "batch", length = 50, nullable = false)
	private String batch;




}
