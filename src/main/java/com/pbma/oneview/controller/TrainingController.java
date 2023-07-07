package com.pbma.oneview.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.pbma.oneview.entity.Training;
import com.pbma.oneview.service.TrainingService;

@Controller
public class TrainingController {

	final TrainingService trainingService;

	public TrainingController(TrainingService trainingService) {
		this.trainingService = trainingService;
	}

	@RequestMapping({"/trainings"})
	public String findAllTrainings(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {

		var currentPage = page.orElse(1);
		var pageSize = size.orElse(5);
		var bookPage = trainingService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

		model.addAttribute("trainings", bookPage);

		int totalPages = bookPage.getTotalPages();
		if (totalPages > 0) {
			var pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		return "list-trainings";
	}

	@GetMapping(path="/trainingResponse", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Training>> findAllTrainingResponse() {
		var trainings = trainingService.findAllTrainings();
		return ResponseEntity.ok(trainings);
	}

	@RequestMapping("/training/{id}")
	public String findTrainingById(@PathVariable("id") Long id, Model model) {

		model.addAttribute("training", trainingService.findTrainingById(id));
		return "list-training";
	}

	@GetMapping("/addTraining")
	public String showCreateForm(Training training) {
		return "add-training";
	}

	@RequestMapping("/add-training")
	public String createTraining(Training training, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-training";
		}

		trainingService.createTraining(training);
		model.addAttribute("training", trainingService.findAllTrainings());
		return "redirect:/trainings";
	}

	@GetMapping("/updateTraining/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {

		model.addAttribute("training", trainingService.findTrainingById(id));
		return "update-training";
	}

	@RequestMapping("/update-training/{id}")
	public String updateTraining(@PathVariable("id") Long id, Training training, BindingResult result, Model model) {
		if (result.hasErrors()) {
			training.setId(id);
			return "update-training";
		}

		trainingService.updateTraining(training);
		model.addAttribute("training", trainingService.findAllTrainings());
		return "redirect:/trainings";
	}

	@RequestMapping("/remove-training/{id}")
	public String deleteTraining(@PathVariable("id") Long id, Model model) {
		trainingService.deleteTraining(id);

		model.addAttribute("training", trainingService.findAllTrainings());
		return "redirect:/trainings";
	}

}
