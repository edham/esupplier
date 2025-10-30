
package com.ebim.esupplier.controller;

import com.ebim.esupplier.security.JwtService;
import com.ebim.esupplier.security.User;
import com.ebim.esupplier.security.UserRepository;
import com.ebim.esupplier.web.dto.LoginRequest;
import com.ebim.esupplier.web.dto.RegisterRequest;
import com.ebim.esupplier.web.dto.TokenResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(UserRepository userRepository, PasswordEncoder encoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest req) {
        if (userRepository.findByUsername(req.username()).isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("error", "username already exists"));
        }
        User u = User.builder()
                .username(req.username())
                .email(req.email())
                .password(encoder.encode(req.password()))
                .enabled(true)
                .build();
        userRepository.save(u);
        return ResponseEntity.ok(Map.of("id", u.getId(), "username", u.getUsername(), "email", u.getEmail()));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody @Valid LoginRequest req) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.username(), req.password()));
        String token = jwtService.generate(req.username(), Map.of("scope","user"));
        long expires = 60L * 60L * 8L; // 8h
        return ResponseEntity.ok(new TokenResponse(token, expires));
    }
}
