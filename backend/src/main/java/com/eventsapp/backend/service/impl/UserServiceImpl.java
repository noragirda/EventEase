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

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));
        userRepository.delete(user);
    }
}
