package com.pbma.oneview.service;

import com.pbma.oneview.entity.Trainee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TraineeService {

	public List<Trainee> findAllTrainees();

	public Trainee findTraineeById(Long id);

	public void createTrainee(Trainee trainee);

	public void updateTrainee(Trainee trainee);

	public void deleteTrainee(Long id);

	public Page<Trainee> findPaginated(Pageable pageable);

}
