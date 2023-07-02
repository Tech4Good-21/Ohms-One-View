package com.pbma.oneview.util;

import java.util.List;
import java.util.stream.Collectors;

import com.pbma.oneview.entity.Author;
import com.pbma.oneview.entity.Trainee;
import com.pbma.oneview.vo.AuthorRecord;
import com.pbma.oneview.vo.TraineeRecord;

public class Mapper {

	public static List<AuthorRecord> authorModelToVo(List<Author> authors) {

		return authors.stream().map(vo -> {
			var authorVo = new AuthorRecord(vo.getId(), vo.getName(), vo.getDescription());
			return authorVo;
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
