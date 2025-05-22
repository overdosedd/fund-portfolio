package com.example.mutualfundportfolio.controller;

import com.example.mutualfundportfolio.entity.User;
import com.example.mutualfundportfolio.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.io.Decoders;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.secret}")
    private String secretKey;

    public AuthController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        return userService.findByEmail(email)
                .filter(user -> passwordEncoder.matches(password, user.getPasswordHash()))
                .map(user -> {
                    // Decode Base64 secret key to bytes
                    byte[] keyBytes = Decoders.BASE64.decode(secretKey);
                    SecretKey key = Keys.hmacShaKeyFor(keyBytes);

                    String token = Jwts.builder()
                            .setSubject(user.getEmail())
                            .setIssuedAt(new Date())
                            .setExpiration(new Date(System.currentTimeMillis() + 3600_000)) // 1 hour
                            .signWith(key, SignatureAlgorithm.HS256)
                            .compact();
                    return ResponseEntity.ok(Map.of("token", token));
                })
                .orElse(ResponseEntity.status(401).body(Map.of("error", "Invalid email or password")));
    }
}
