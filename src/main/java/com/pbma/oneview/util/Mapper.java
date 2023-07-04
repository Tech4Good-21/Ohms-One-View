package com.pbma.oneview.util;

import java.util.List;
import java.util.stream.Collectors;

import com.pbma.oneview.entity.Training;
import com.pbma.oneview.entity.Trainee;
import com.pbma.oneview.vo.TrainingRecord;
import com.pbma.oneview.vo.TraineeRecord;

public class Mapper {

	public static List<TrainingRecord> trainingModelToVo(List<Training> trainings) {

		return trainings.stream().map(vo -> {
			var trainingVo = new TrainingRecord(vo.getId(), vo.getName(), vo.getDescription(), vo.getBatch());
			return trainingVo;
		}).collect(Collectors.toList());

	}

	public static List<TraineeRecord> traineeModelToVo(List<Trainee> trainees) {

		return trainees.stream().map(vo -> {
			var traineeVo = new TraineeRecord(vo.getId(),vo.getName(),
					vo.getGender(), vo.getIdType(),
					vo.getIdNumber(), vo.getEmail(),
					vo.getAddress(), vo.getDistrict(),vo.getPin(),
					vo.getState());
			return traineeVo;
		}).collect(Collectors.toList());

	}
}
