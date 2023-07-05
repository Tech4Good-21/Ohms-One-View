package com.pbma.oneview.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pbma.oneview.entity.Training;

public interface TrainingService {

	public List<Training> findAllTrainings();

	public Training findTrainingById(Long id);

	public void createTraining(Training training);

	public void updateTraining(Training training);

	public void deleteTraining(Long id);

	public Page<Training> findPaginated(Pageable pageable);

}
