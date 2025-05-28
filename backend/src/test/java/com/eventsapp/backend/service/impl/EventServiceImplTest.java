package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.dto.EventUpdateRequest;
import com.eventsapp.backend.model.Client;
import com.eventsapp.backend.model.Event;
import com.eventsapp.backend.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventServiceImplTest {

    @Mock
    private MenuRepository menuRepository;
    @Mock
    private DrinkRepository drinkRepository;
    @Mock
    private FruitsRepository fruitsRepository;
    @Mock
    private MiscellaneousRepository miscellaneousRepository;
    @Mock
    private EventRepository eventRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ApetizerRepository apetizerRepository;
    @Mock
    private SoupRepository soupRepository;
    @Mock
    private MainCourseRepository mainCourseRepository;

    @InjectMocks
    private EventServiceImpl eventService;

    private Event event;
    private Client client;

    @BeforeEach
    void setup() {
        event = new Event();
        event.setId(1L);
        event.setEventDate(java.sql.Date.valueOf(LocalDate.now().plusDays(20)));
        event.setClientIds(List.of());

        client = new Client();
        client.setEmail("client@test.com");
        client.setId(1L);
    }

    @Test
    void updateClientEvent_throwsIfNotAuthorized() {
        event.setClientIds(List.of()); // client not in list

        when(userRepository.findByEmail("client@test.com")).thenReturn(Optional.of(client));
        when(eventRepository.findById(1L)).thenReturn(Optional.of(event));

        EventUpdateRequest request = new EventUpdateRequest();
        request.setFinalAdultCount(100);

        assertThrows(RuntimeException.class, () ->
                eventService.updateClientEvent(1L, "client@test.com", request));
    }
    @Test
    void updateClientEvent_throwsIfTooCloseToEvent() {
        event.setEventDate(java.sql.Date.valueOf(LocalDate.now().plusDays(5)));
        event.setClientIds(List.of(client));

        when(userRepository.findByEmail("client@test.com")).thenReturn(Optional.of(client));
        when(eventRepository.findById(1L)).thenReturn(Optional.of(event));

        EventUpdateRequest request = new EventUpdateRequest();

        assertThrows(RuntimeException.class, () ->
                eventService.updateClientEvent(1L, "client@test.com", request));
    }


}
