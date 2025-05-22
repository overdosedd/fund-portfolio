package com.example.mutualfundportfolio.controller;

import com.example.mutualfundportfolio.entity.User;
import com.example.mutualfundportfolio.repository.UserRepository;
import com.example.mutualfundportfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User created = userService.saveUser(user);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/email")
    public ResponseEntity<?> getUserByEmail(@RequestParam String email) {
        Optional<User> user = userService.findByEmail(email);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Map<String, String> userMap) {
        String email = userMap.get("email");
        String plainPassword = userMap.get("password");

        if (email == null || plainPassword == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Email and password are required"));
        }

        // Check if user already exists
        if (userRepository.findByEmail(email).isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Email already registered"));
        }

        // Hash password before saving
        String hashedPassword = passwordEncoder.encode(plainPassword);

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPasswordHash(hashedPassword);

        userRepository.save(newUser);

        return ResponseEntity.ok(Map.of("message", "User registered successfully"));
    }
}