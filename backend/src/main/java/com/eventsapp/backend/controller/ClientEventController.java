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

/**
 * REST controller for client-side operations related to managing their events.
 * Allows clients to view, update, and customize their events, menus, drinks, fruits, and miscellaneous options.
 */
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

    /**
     * Retrieves the list of events associated with the currently logged-in client.
     *
     * @param principal the security context containing the client's email
     * @return a list of {@link Event} instances for the client
     */
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

    /**
     * Updates basic event information such as type, guest count, start time, and menu for the specified event.
     *
     * @param id        the ID of the event to update
     * @param request   the update request containing new values
     * @param principal the logged-in client's identity
     * @return a success response upon successful update
     */
    @PutMapping("/events/{id}")
    public ResponseEntity<?> updateEvent(
            @PathVariable Long id,
            @RequestBody EventUpdateRequest request,
            Principal principal
    ) {
        eventService.updateClientEvent(id, principal.getName(), request);
        return ResponseEntity.ok("Event updated.");
    }

    /**
     * Retrieves all available menus from the system.
     *
     * @return a list of {@link Menu} entities
     */
    @GetMapping("/menus")
    public List<Menu> getMenus() {
        return menuRepository.findAll();
    }

    /**
     * Retrieves all available drinks.
     *
     * @return a list of {@link Drink} options
     */
    @GetMapping("/drinks")
    public List<Drink> getDrinks() {
        return drinkRepository.findAll();
    }

    /**
     * Retrieves all available fruits.
     *
     * @return a list of {@link Fruits} options
     */
    @GetMapping("/fruits")
    public List<Fruits> getFruits() {
        return fruitsRepository.findAll();
    }

    /**
     * Retrieves all available miscellaneous options.
     *
     * @return a list of {@link Miscellaneous} settings
     */
    @GetMapping("/misc")
    public List<Miscellaneous> getMisc() {
        return miscellaneousRepository.findAll();
    }

    /**
     * Updates the miscellaneous options for a specific event.
     *
     * @param eventId the ID of the event
     * @param request the new miscellaneous configuration
     * @return HTTP 200 OK upon success
     */
    @PutMapping("/events/{eventId}/misc")
    public ResponseEntity<?> updateMisc(@PathVariable Long eventId, @RequestBody MiscellaneousRequest request) {
        eventService.updateMiscellaneous(eventId, request);
        return ResponseEntity.ok().build();
    }
}
