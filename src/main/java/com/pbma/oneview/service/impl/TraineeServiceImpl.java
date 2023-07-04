package com.pbma.oneview.service.impl;

import com.pbma.oneview.entity.Trainee;
import com.pbma.oneview.exception.NotFoundException;
import com.pbma.oneview.repository.TraineeRepository;
import com.pbma.oneview.service.TraineeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class TraineeServiceImpl implements TraineeService {

	final TraineeRepository traineeRepository;

	public TraineeServiceImpl(TraineeRepository traineeRepository) {
		this.traineeRepository = traineeRepository;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Trainee> findAllTrainees() {
		return traineeRepository.findAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public Trainee findTraineeById(Long id) {
		return traineeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Trainee not found with ID %d", id)));
	}

	@Override
	public void createTrainee(Trainee training) {
		traineeRepository.save(training);
	}

	@Override
	public void updateTrainee(Trainee training) {
		traineeRepository.save(training);
	}

	@Override
	public void deleteTrainee(Long id) {
		var training = traineeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Trainee not found with ID %d", id)));

		traineeRepository.deleteById(training.getId());
	}

	@Override
	public Page<Trainee> findPaginated(Pageable pageable) {

		var pageSize = pageable.getPageSize();
		var currentPage = pageable.getPageNumber();
		var startItem = currentPage * pageSize;
		List<Trainee> list;

		if (findAllTrainees().size() < startItem) {
			list = Collections.emptyList();
		} else {
			var toIndex = Math.min(startItem + pageSize, findAllTrainees().size());
			list = findAllTrainees().subList(startItem, toIndex);
		}

		return new PageImpl<Trainee>(list, PageRequest.of(currentPage, pageSize), findAllTrainees().size());

	}

}
