package com.project.dengue_zero.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.dengue_zero.dto.UserDTO;
import com.project.dengue_zero.entities.User;
import com.project.dengue_zero.services.UserService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final UserService service;

    public UserResource(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserDTO dto,
                                         HttpServletRequest request) {

        String authenticatedUid = (String) request.getAttribute("firebaseUid");

        if (!authenticatedUid.equals(dto.getUid())) {
            return ResponseEntity.status(403).build();
        }

        User savedUser = service.saveOrUpdate(dto);
        return ResponseEntity.ok(savedUser);
    }
}
