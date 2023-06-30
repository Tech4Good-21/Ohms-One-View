package com.pbma.oneview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pbma.oneview.entity.Trainee;
import com.pbma.oneview.service.OneViewService;

@RestController
public class OneViewController {
	
	@Autowired
	private OneViewService oneViewService;
	
	@GetMapping("/trainees")
	public List<Trainee> getTrainees() {
		return oneViewService.getTrainees();
	}
	
	@GetMapping("/trainees/{traineeId}")
	public Trainee getTrainee(@PathVariable Integer traineeId) {
		return oneViewService.getTrainee(traineeId);
	}

	@PostMapping("/trainees")
	public Trainee addTrainee(@RequestBody Trainee trainee) {
		return oneViewService.addTrainee(trainee);
	}
	
	@PutMapping("/trainees")
	public Trainee updateTrainee(@RequestBody Trainee trainee) {
		return oneViewService.updateTrainee(trainee);
	}
	
	@DeleteMapping("/trainees/{traineeId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Integer traineeId) {
		try {
			oneViewService.deleteTrainee(traineeId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}