package com.eventsapp.backend.controller;

import com.eventsapp.backend.dto.AdminEventPriceUpdateRequest;
import com.eventsapp.backend.dto.FullEventDetailsResponse;
import com.eventsapp.backend.service.impl.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for administrative actions on events.
 * Allows admins to update event pricing and retrieve full event details.
 */
@RestController
@RequestMapping("/api/admin/events")
@RequiredArgsConstructor
public class AdminEventController {

    /**
     * Service layer for event-related operations.
     */
    private final EventService eventService;

    /**
     * Updates the pricing for an event (price per adult and child).
     *
     * @param eventId the ID of the event to update
     * @param request the request containing updated price values
     * @return HTTP 200 OK if the update was successful
     */
    @PutMapping("/{eventId}/update-price")
    public ResponseEntity<Void> updateEventPrices(
            @PathVariable Long eventId,
            @RequestBody AdminEventPriceUpdateRequest request
    ) {
        eventService.updateEventPrices(eventId, request);
        return ResponseEntity.ok().build();
    }

    /**
     * Retrieves full event details including menu, drinks, fruits, and miscellaneous settings.
     *
     * @param eventId the ID of the event to retrieve
     * @return a {@link FullEventDetailsResponse} containing all details for the specified event
     */
    @GetMapping("/{eventId}/full")
    public ResponseEntity<FullEventDetailsResponse> getFullEventDetails(@PathVariable Long eventId) {
        return ResponseEntity.ok(eventService.getFullEventDetails(eventId));
    }
}
