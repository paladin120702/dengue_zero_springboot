package com.project.dengue_zero.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.dengue_zero.entities.Denounces;
import com.project.dengue_zero.services.DenouncesService;

@RestController
@RequestMapping(value = "/denounces")
public class DenouncesResource {
	
	@Autowired
	private DenouncesService service;
	
	@GetMapping
	public ResponseEntity<List<Denounces>> findAll() {
		List<Denounces> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
