package com.vitoria.foodexpress_backend.controllers;

import com.vitoria.foodexpress_backend.entities.User;
import com.vitoria.foodexpress_backend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public LoginController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User found = userService.findByEmail(user.getEmail());
        if (found != null && passwordEncoder.matches(user.getPassword(), found.getPassword())) {
            return ResponseEntity.ok("Login bem-sucedido");
        }
        return ResponseEntity.status(401).body("Email ou senha inválidos");
    }
}

