package com.project.dengue_zero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.dengue_zero.entities.Denounces;

public interface DenouncesRepository extends JpaRepository<Denounces, Long> {
}
