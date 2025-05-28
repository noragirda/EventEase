package com.eventsapp.backend.controller;

import com.eventsapp.backend.dto.EventUpdateRequest;
import com.eventsapp.backend.dto.MiscellaneousRequest;
import com.eventsapp.backend.model.*;
import com.eventsapp.backend.repository.*;
import com.eventsapp.backend.service.impl.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientEventController {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final EventService eventService;
    private final MenuRepository menuRepository;
    private final FruitsRepository fruitsRepository;
    private final DrinkRepository drinkRepository;
    private final MiscellaneousRepository miscellaneousRepository;

    @GetMapping("/my-events")
    public List<Event> getClientEvents(Principal principal) {
        String email = principal.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!(user instanceof Client client)) {
            throw new RuntimeException("Only clients can view their events.");
        }

        return eventRepository.findByClientIdsContains(client);
    }
    @PutMapping("/events/{id}")
    public ResponseEntity<?> updateEvent(
            @PathVariable Long id,
            @RequestBody EventUpdateRequest request,
            Principal principal
    ) {
        eventService.updateClientEvent(id, principal.getName(), request);
        return ResponseEntity.ok("Event updated.");
    }
    @GetMapping("/menus")
    public List<Menu> getMenus() { return menuRepository.findAll(); }

    @GetMapping("/drinks")
    public List<Drink> getDrinks() { return drinkRepository.findAll(); }

    @GetMapping("/fruits")
    public List<Fruits> getFruits() { return fruitsRepository.findAll(); }

    @GetMapping("/misc")
    public List<Miscellaneous> getMisc() { return miscellaneousRepository.findAll(); }
    @PutMapping("/events/{eventId}/misc")
    public ResponseEntity<?> updateMisc(@PathVariable Long eventId, @RequestBody MiscellaneousRequest request) {
        eventService.updateMiscellaneous(eventId, request);
        return ResponseEntity.ok().build();
    }

}
