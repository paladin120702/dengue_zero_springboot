package com.project.dengue_zero.services;

import java.util.List;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dengue_zero.dto.DenouncesDTO;
import com.project.dengue_zero.entities.Denounces;
import com.project.dengue_zero.entities.User;
import com.project.dengue_zero.repositories.DenouncesRepository;

@Service
public class DenouncesService {
	
	@Autowired
	private DenouncesRepository repository;
	
	public Denounces createDenounce(@NonNull DenouncesDTO dto, User user) {
		Denounces denounce = new Denounces();
	    denounce.setTitle(dto.getTitle());
	    denounce.setImgUrl(dto.getImgUrl());
	    denounce.setLatitude(dto.getLatitude());
	    denounce.setLongitude(dto.getLongitude());
	    denounce.setClient(user);

	    return repository.save(denounce);
	}
	
	public List<Denounces> findAllByUser(User user) {
        return repository.findByClient(user);
	}
	
	public List<Denounces> findAll() {
		return repository.findAll();
	}
}
