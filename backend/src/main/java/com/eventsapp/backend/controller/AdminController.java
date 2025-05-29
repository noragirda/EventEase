package com.eventsapp.backend.controller;

import com.eventsapp.backend.dto.UserResponse;
import com.eventsapp.backend.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for admin operations related to user management.
 * Allows administrators to retrieve and delete users.
 */
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    /**
     * Service for handling user-related operations.
     */
    private final UserService userService;

    /**
     * Retrieves a list of all registered users in the system.
     *
     * @return a list of {@link UserResponse} objects wrapped in an HTTP 200 OK response
     */
    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * Deletes a user by their unique identifier.
     *
     * @param id the ID of the user to delete
     * @return HTTP 204 No Content response on successful deletion
     */
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
