package com.project.dengue_zero.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.project.dengue_zero.dto.DenouncesDTO;
import com.project.dengue_zero.entities.Denounces;
import com.project.dengue_zero.entities.User;
import com.project.dengue_zero.repositories.UserRepository;
import com.project.dengue_zero.services.DenouncesService;

@RestController
@RequestMapping(value = "/denounces")
public class DenouncesResource {
	
	@Autowired
	private DenouncesService service;
	
	@Autowired
	private UserRepository repository;
	
	@PostMapping
	public ResponseEntity<?> createDenounce(@RequestHeader("Authorization") String authorization,
	                                        @RequestBody DenouncesDTO denounceDTO) {
		try {
			String token = authorization.replace("Bearer ", "");
	        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
	        String uid = decodedToken.getUid();
	        
	        User user = repository.findById(uid).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

	        if (denounceDTO.getTitulo() == null || denounceDTO.getTitulo().isBlank()) {
                return ResponseEntity.badRequest().body("Título é obrigatório");
            }
	        
	        if (denounceDTO.getLatitude() == null || denounceDTO.getLatitude().isBlank() ||
	        	denounceDTO.getLongitude() == null || denounceDTO.getLongitude().isBlank()) {
	        	return ResponseEntity.badRequest().body("Latitude e longitude são obrigatórias");
	        }
	        
	        Denounces savedDenounce = service.createDenounce(denounceDTO, user);

	        return ResponseEntity.ok(savedDenounce);

		} catch (Exception e) {
			return ResponseEntity.status(401).body("Token inválido ou erro ao criar denúncia: " + e.getMessage());
	    }
	}
	
	@GetMapping
	public ResponseEntity<List<Denounces>> findAll() {
		List<Denounces> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
