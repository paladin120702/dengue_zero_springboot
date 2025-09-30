package com.project.dengue_zero.services;

import java.util.List;
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
	
	public Denounces createDenounce(DenouncesDTO dto, User user) {
		Denounces denounce = new Denounces();
	    denounce.setTitulo(dto.getTitulo());
	    denounce.setImgUrl(dto.getImgUrl());
	    denounce.setLatitude(dto.getLatitude());
	    denounce.setLongitude(dto.getLongitude());
	    denounce.setClient(user);

	    return repository.save(denounce);
	}
	
	public List<Denounces> findAll() {
		return repository.findAll();
	}
}
