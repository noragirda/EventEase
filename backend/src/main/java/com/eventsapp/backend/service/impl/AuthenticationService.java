package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.config.JwtUtil;
import com.eventsapp.backend.dto.AuthResponse;
import com.eventsapp.backend.dto.LoginRequest;
import com.eventsapp.backend.dto.RegisterRequest;
import com.eventsapp.backend.model.Admin;
import com.eventsapp.backend.model.Client;
import com.eventsapp.backend.model.User;
import com.eventsapp.backend.model.enums.Role;
import com.eventsapp.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service responsible for user authentication and registration.
 * Handles registration of new users and login authentication.
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authManager;

    /**
     * Registers a new user (Admin or Client) based on the provided request.
     * Encodes the password and generates a JWT token upon successful registration.
     *
     * @param request the registration request containing user details
     * @return an {@link AuthResponse} containing the JWT token
     */
    public AuthResponse register(RegisterRequest request) {
        User user;
        if (request.getRole().equals(Role.ADMIN)) {
            user = new Admin(); // Ensure Admin class has appropriate constructor
        } else {
            user = new Client();
        }
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        userRepository.save(user);
        String token = jwtUtil.generateToken(user);
        return new AuthResponse(token);
    }

    /**
     * Authenticates a user by verifying credentials.
     * Generates a JWT token upon successful authentication.
     *
     * @param request the login request containing email and password
     * @return an {@link AuthResponse} containing the JWT token
     * @throws UsernameNotFoundException if user with given email does not exist
     */
    public AuthResponse login(LoginRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String token = jwtUtil.generateToken(user);
        return new AuthResponse(token);
    }
}
