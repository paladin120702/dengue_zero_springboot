package com.project.dengue_zero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.dengue_zero.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
}