package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.dto.UserResponse;
import com.eventsapp.backend.exception.NotFoundException;
import com.eventsapp.backend.mapper.UserMapper;
import com.eventsapp.backend.model.User;
import com.eventsapp.backend.repository.UserRepository;
import com.eventsapp.backend.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for managing users.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /**
     * Retrieves all users and maps them to {@link UserResponse} DTOs.
     *
     * @return a list of user responses representing all users
     */
    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Deletes a user by their ID.
     *
     * @param userId the ID of the user to delete
     * @throws NotFoundException if the user with the given ID does not exist
     */
    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));
        userRepository.delete(user);
    }
}
