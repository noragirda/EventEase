package com.eventsapp.backend.controller;

import com.eventsapp.backend.dto.AuthResponse;
import com.eventsapp.backend.dto.LoginRequest;
import com.eventsapp.backend.dto.RegisterRequest;
import com.eventsapp.backend.service.impl.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller responsible for handling authentication operations,
 * such as user registration and login.
 */
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    /**
     * Service for handling registration and authentication logic.
     */
    private final AuthenticationService authService;

    /**
     * Registers a new user based on the provided request data.
     *
     * @param request the registration request containing user credentials and role
     * @return an {@link AuthResponse} containing a JWT token and user info
     */
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    /**
     * Authenticates a user and returns a JWT token if credentials are valid.
     *
     * @param request the login request containing email and password
     * @return an {@link AuthResponse} containing a JWT token and user info
     */
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
