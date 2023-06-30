package com.pbma.oneview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbma.oneview.dao.OneViewDao;
import com.pbma.oneview.entity.Trainee;

@Service
public class OneViewServiceImpl implements OneViewService {
	
	@Autowired
	private OneViewDao oneViewDao;

	@Override
	public List<Trainee> getTrainees() {
		return oneViewDao.findAll();
	}

	@Override
	public Trainee getTrainee(Integer traineeId) {
		return oneViewDao.getById(traineeId);
	}

	@Override
	public Trainee addTrainee(Trainee trainee) {
		oneViewDao.save(trainee);
		return trainee;
	}

	@Override
	public Trainee updateTrainee(Trainee trainee) {
		oneViewDao.save(trainee);
		return trainee;
	}

	@Override
	public void deleteTrainee(Integer traineeId) {
		oneViewDao.delete(oneViewDao.getById(traineeId));
	}
	
}