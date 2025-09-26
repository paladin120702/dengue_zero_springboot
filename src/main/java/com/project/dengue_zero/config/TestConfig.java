package com.project.dengue_zero.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.project.dengue_zero.entities.Denounces;
import com.project.dengue_zero.entities.User;
import com.project.dengue_zero.repositories.DenouncesRepository;
import com.project.dengue_zero.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DenouncesRepository denouncesRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User("u1", "Arthur Morgan", "arthurmorgan@gmail.com");
		User u2 = new User("u2", "Jhon Marston", "jhonmarston@gmail.com");
		
		Denounces d1 = new Denounces(null, "perto da pampulha", "https://bvsms.saude.gov.br/dengue-16/", "15;52;5çç;25ç", "51:522/;55", u1);
		Denounces d2 = new Denounces(null, "perto da abaeté", "https://bvsms.saude.gov.br/dengue-16/", "15;52;5çç;25ç", "51:522/;55", u2);
	
		userRepository.saveAll(Arrays.asList(u1, u2));
		denouncesRepository.saveAll(Arrays.asList(d1, d2));
	}
}
