package com.project.dengue_zero.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dengue_zero.entities.Denounces;
import com.project.dengue_zero.repositories.DenouncesRepository;

@Service
public class DenouncesService {
	
	@Autowired
	private DenouncesRepository repository;
	
	public List<Denounces> findAll() {
		return repository.findAll();
	}
}
