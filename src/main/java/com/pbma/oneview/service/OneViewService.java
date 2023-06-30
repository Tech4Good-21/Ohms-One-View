package com.pbma.oneview.service;

import java.util.List;

import com.pbma.oneview.entity.Trainee;

public interface OneViewService {

	public List<Trainee> getTrainees();
	
	public Trainee getTrainee(Long traineeId);
	
	public Trainee addTrainee(Trainee trainee);
	
	public Trainee updateTrainee(Trainee trainee);
	
	public void deleteTrainee(Long traineeId);
	
}