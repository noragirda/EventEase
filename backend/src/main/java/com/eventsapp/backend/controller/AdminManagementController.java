package com.eventsapp.backend.controller;

import com.eventsapp.backend.dto.AdminEventPriceUpdateRequest;
import com.eventsapp.backend.dto.VenueWithEventsResponse;
import com.eventsapp.backend.service.impl.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for administrative venue and event management.
 * Allows admins to view venues they manage and update event pricing.
 */
@RestController
@RequestMapping("/api/admin/management")
@RequiredArgsConstructor
public class AdminManagementController {

    /**
     * Service for handling event-related operations.
     */
    private final EventService eventService;

    /**
     * Retrieves all venues and their associated events for the logged-in admin.
     *
     * @param email the email of the admin (used to identify their assigned venues)
     * @return a list of venues along with their scheduled events
     */
    @GetMapping("/my-venues")
    public ResponseEntity<List<VenueWithEventsResponse>> getMyVenuesAndEvents(@RequestParam String email) {
        return ResponseEntity.ok(eventService.getVenuesWithEventsByAdminEmail(email));
    }

    /**
     * Updates the calculated price per adult and child for a specific event.
     *
     * @param eventId the ID of the event to update
     * @param request the updated price values
     * @return HTTP 200 OK response on successful update
     */
    @PutMapping("/events/{eventId}/update-price")
    public ResponseEntity<Void> updateEventPrices(
            @PathVariable Long eventId,
            @RequestBody AdminEventPriceUpdateRequest request
    ) {
        eventService.updateEventPrices(eventId, request);
        return ResponseEntity.ok().build();
    }
}
