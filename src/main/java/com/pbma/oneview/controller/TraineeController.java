package com.pbma.oneview.controller;

import com.pbma.oneview.entity.Trainee;
import com.pbma.oneview.entity.Training;
import com.pbma.oneview.service.TraineeService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class TraineeController {

	final TraineeService traineeService;

	public TraineeController(TraineeService traineeService) {
		this.traineeService = traineeService;
	}

	@RequestMapping({"/trainees", "/"})
	public String findAllTrainees(Model model, @RequestParam("page") Optional<Integer> page,
								 @RequestParam("size") Optional<Integer> size) {

		var currentPage = page.orElse(1);
		var pageSize = size.orElse(5);
		var bookPage = traineeService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

		model.addAttribute("trainees", bookPage);

		int totalPages = bookPage.getTotalPages();
		if (totalPages > 0) {
			var pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		return "list-trainees";
	}

	@RequestMapping("/trainee/{id}")
	public String findTraineeById(@PathVariable("id") Long id, Model model) {

		model.addAttribute("trainee", traineeService.findTraineeById(id));
		return "list-trainee";
	}

	@GetMapping("/addTrainee")
	public String showCreateForm(Trainee trainee, Model model) {

		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8081/trainingResponse";


		// URL of the other controller's endpoint
		ResponseEntity<List<Training>> response = restTemplate.exchange(
				url,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Training>>() {});

		List<Training> trainings = response.getBody();
		model.addAttribute("trainings", trainings);
		return "add-trainee";
	}

	@RequestMapping("/add-trainee")
	public String createTrainee(Trainee trainee, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-trainee";
		}

		traineeService.createTrainee(trainee);
		model.addAttribute("trainee", traineeService.findAllTrainees());
		return "redirect:/trainees";
	}

	@GetMapping("/updateTrainee/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {

		model.addAttribute("trainee", traineeService.findTraineeById(id));
		return "update-trainee";
	}

	@RequestMapping("/update-trainee/{id}")
	public String updateTrainee(@PathVariable("id") Long id, Trainee trainee, BindingResult result, Model model) {
		if (result.hasErrors()) {
			trainee.setId(id);
			return "update-trainee";
		}

		traineeService.updateTrainee(trainee);
		model.addAttribute("trainee", traineeService.findAllTrainees());
		return "redirect:/trainees";
	}

	@RequestMapping("/remove-trainee/{id}")
	public String deleteTrainee(@PathVariable("id") Long id, Model model) {
		traineeService.deleteTrainee(id);

		model.addAttribute("trainee", traineeService.findAllTrainees());
		return "redirect:/trainees";
	}

}
