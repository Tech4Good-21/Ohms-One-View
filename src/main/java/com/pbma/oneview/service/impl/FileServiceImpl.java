package com.pbma.oneview.service.impl;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.pbma.oneview.constant.Item;
import com.pbma.oneview.service.TrainingService;
import com.pbma.oneview.service.FileService;
import com.pbma.oneview.service.TraineeService;
import com.pbma.oneview.util.Mapper;
import com.pbma.oneview.vo.TrainingRecord;
import com.pbma.oneview.vo.TraineeRecord;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Service
public class FileServiceImpl implements FileService {
	final TrainingService trainingService;

	final TraineeService traineeService;

	public FileServiceImpl(TrainingService trainingService, TraineeService traineeService) {
		this.trainingService = trainingService;
		this.traineeService = traineeService;
	}

	@Override
	public void exportCSV(String fileName, HttpServletResponse response)
			throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
		var item = Item.getItemByValue(fileName);
		response.setContentType("text/csv");
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + item.get().getFileName() + "\"");

		switch (item.get()) {
			case TRAINING:
				StatefulBeanToCsv<TrainingRecord> trainingWriter = getWriter(response.getWriter());
				trainingWriter.write(Mapper.trainingModelToVo(trainingService.findAllTrainings()));
				break;
			case TRAINEE:
				StatefulBeanToCsv<TraineeRecord> traineeWriter = getWriter(response.getWriter());
				traineeWriter.write(Mapper.traineeModelToVo(traineeService.findAllTrainees()));
				break;
		}

	}

	private static <T> StatefulBeanToCsv<T> getWriter(PrintWriter printWriter) {
		return new StatefulBeanToCsvBuilder<T>(printWriter).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
				.withSeparator(CSVWriter.DEFAULT_SEPARATOR).withOrderedResults(false).build();
	}
}
