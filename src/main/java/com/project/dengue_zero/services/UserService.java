package com.project.dengue_zero.services;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.dengue_zero.dto.UserDTO;
import com.project.dengue_zero.entities.User;
import com.project.dengue_zero.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public User saveOrUpdate(@NonNull UserDTO dto) {
        User user = repository.findById(dto.getUid()).orElse(new User(dto.getUid(), dto.getEmail(), dto.getName()));
        
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());

        return repository.save(user);
    }
}