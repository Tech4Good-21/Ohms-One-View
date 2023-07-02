package com.pbma.oneview;


import com.pbma.oneview.entity.Role;
import com.pbma.oneview.entity.User;
import com.pbma.oneview.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pbma.oneview.repository.UserRepository;

import java.util.Arrays;

@SpringBootApplication
public class Application {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate() {
		return (args) -> {

//			authorService.createAuthor(new Author("Matt", "dummy description"));
//
//			authorService.createAuthor(new Author("Maxwell", "Test description1"));
//
//			authorService.createAuthor(new Author("Josh Lang", "Test description2"));

//			var user = new User("admin", "admin", "admin@admin.in", passwordEncoder.encode("Temp123"),
//					Arrays.asList(new Role("ROLE_ADMIN")));
//			userRepository.save(user);

		};
	}
}
