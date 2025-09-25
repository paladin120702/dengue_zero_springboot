package com.project.dengue_zero.services;

import org.springframework.stereotype.Service;
import com.project.dengue_zero.repositories.DenouncesRepository;

@Service
public class DenouncesService {

	private final DenouncesRepository repository;
	
	public DenouncesService(DenouncesRepository repository) {
		this.repository = repository;
	}
}
