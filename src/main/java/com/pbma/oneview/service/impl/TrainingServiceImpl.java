package com.pbma.oneview.service.impl;

import java.util.Collections;
import java.util.List;

import com.pbma.oneview.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pbma.oneview.entity.Training;
import com.pbma.oneview.repository.TrainingRepository;
import com.pbma.oneview.service.TrainingService;

@Service
public class TrainingServiceImpl implements TrainingService {

	final TrainingRepository trainingRepository;

	public TrainingServiceImpl(TrainingRepository trainingRepository) {
		this.trainingRepository = trainingRepository;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Training> findAllTrainings() {
		return trainingRepository.findAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public Training findTrainingById(Long id) {
		return trainingRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Training not found with ID %d", id)));
	}

	@Override
	public void createTraining(Training training) {
		trainingRepository.save(training);
	}

	@Override
	public void updateTraining(Training training) {
		trainingRepository.save(training);
	}

	@Override
	public void deleteTraining(Long id) {
		var training = trainingRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Training not found with ID %d", id)));

		trainingRepository.deleteById(training.getId());
	}

	@Override
	public Page<Training> findPaginated(Pageable pageable) {

		var pageSize = pageable.getPageSize();
		var currentPage = pageable.getPageNumber();
		var startItem = currentPage * pageSize;
		List<Training> list;

		if (findAllTrainings().size() < startItem) {
			list = Collections.emptyList();
		} else {
			var toIndex = Math.min(startItem + pageSize, findAllTrainings().size());
			list = findAllTrainings().subList(startItem, toIndex);
		}

		return new PageImpl<Training>(list, PageRequest.of(currentPage, pageSize), findAllTrainings().size());

	}

}
