package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.model.Client;
import com.eventsapp.backend.model.User;
import com.eventsapp.backend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CustomUserDetailsService userDetailsService;

    @Test
    void testLoadUserByUsername_UserExists() {
        Client user = new Client();
        user.setEmail("user@example.com");
        user.setPassword("securepassword");

        when(userRepository.findByEmail("user@example.com")).thenReturn(Optional.of(user));

        User result = (User) userDetailsService.loadUserByUsername("user@example.com");

        assertEquals("user@example.com", result.getEmail());
        assertEquals("securepassword", result.getPassword());
        verify(userRepository).findByEmail("user@example.com");
    }

    @Test
    void testLoadUserByUsername_UserNotFound() {
        when(userRepository.findByEmail("missing@example.com")).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername("missing@example.com");
        });

        verify(userRepository).findByEmail("missing@example.com");
    }
}
