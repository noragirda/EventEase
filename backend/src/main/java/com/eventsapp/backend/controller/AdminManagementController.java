package com.eventsapp.backend.controller;

import com.eventsapp.backend.dto.AdminEventPriceUpdateRequest;
import com.eventsapp.backend.dto.VenueWithEventsResponse;
import com.eventsapp.backend.service.impl.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/management")
@RequiredArgsConstructor
public class AdminManagementController {

    private final EventService eventService;

    // Fetch all venues + events for logged-in admin
    @GetMapping("/my-venues")
    public ResponseEntity<List<VenueWithEventsResponse>> getMyVenuesAndEvents(@RequestParam String email) {
        return ResponseEntity.ok(eventService.getVenuesWithEventsByAdminEmail(email));
    }

    // Update price fields of an event
    @PutMapping("/events/{eventId}/update-price")
    public ResponseEntity<Void> updateEventPrices(
            @PathVariable Long eventId,
            @RequestBody AdminEventPriceUpdateRequest request
    ) {
        eventService.updateEventPrices(eventId, request);
        return ResponseEntity.ok().build();
    }
}


