package com.train.demo;

import com.train.demo.model.User;
import com.train.demo.payload.request.SignupRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(AuthController authController) {
		return args -> {
			Set<String> roles = new HashSet<>();
			roles.add("ADMIN");
			User user = new User("admin", "admin@admin.com", "password123");
			authController.registerUser(new SignupRequest(user.getUsername(), user.getEmail(), roles, user.getPassword()));
		};
	}

}
