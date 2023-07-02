package com.pbma.oneview.controller;

import java.util.List;

import org.apache.commons.logging.Log;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pbma.oneview.entity.Trainee;
import com.pbma.oneview.service.OneViewService;

import jakarta.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@RestController
public class OneViewController {
	
	@Autowired
	private OneViewService oneViewService;
	final Logger logger = LogManager.getLogger(OneViewController.class);

	 @PostMapping("/check")
	    public void fetchData(@Valid @RequestBody String data) {
	        System.out.println("Data received from Postman: " + data);
	    }
	
	@GetMapping("/trainees")
	public List<Trainee> getTrainees() {
		return oneViewService.getTrainees();
	}
	
	@GetMapping("/trainees/{traineeId}")
	public Trainee getTrainee(@PathVariable Long traineeId) {
		return oneViewService.getTrainee(traineeId);
	}

	@PostMapping("/trainees")
	public Trainee addTrainee(@RequestBody Trainee trainee) {
		//logger.info("Received request body: {}",trainee.toString());
		return oneViewService.addTrainee(trainee);
	}
	
	@PutMapping("/trainees")
	public Trainee updateTrainee(@RequestBody Trainee trainee) {
		return oneViewService.updateTrainee(trainee);
	}
	
	@DeleteMapping("/trainees/{traineeId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long traineeId) {
		try {
			oneViewService.deleteTrainee(traineeId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	}