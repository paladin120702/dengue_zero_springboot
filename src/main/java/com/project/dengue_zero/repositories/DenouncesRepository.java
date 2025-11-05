package com.project.dengue_zero.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.dengue_zero.entities.Denounces;
import com.project.dengue_zero.entities.User;

public interface DenouncesRepository extends JpaRepository<Denounces, Long> {
	List<Denounces> findByClient(User client);
}
