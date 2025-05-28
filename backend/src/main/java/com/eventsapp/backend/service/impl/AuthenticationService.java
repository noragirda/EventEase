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

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authManager;

    public AuthResponse register(RegisterRequest request) {
        User user;
        if (request.getRole().equals(Role.ADMIN)) {
            user = new Admin(); // make sure you define this constructor correctly
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
