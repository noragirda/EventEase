package com.eventsapp.backend.controller;

import com.eventsapp.backend.dto.AdminEventPriceUpdateRequest;
import com.eventsapp.backend.dto.FullEventDetailsResponse;
import com.eventsapp.backend.service.impl.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/events")
@RequiredArgsConstructor
public class AdminEventController {

    private final EventService eventService;

    @PutMapping("/{eventId}/update-price")
    public ResponseEntity<Void> updateEventPrices(
            @PathVariable Long eventId,
            @RequestBody AdminEventPriceUpdateRequest request
    ) {
        eventService.updateEventPrices(eventId, request);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{eventId}/full")
    public ResponseEntity<FullEventDetailsResponse> getFullEventDetails(@PathVariable Long eventId) {
        return ResponseEntity.ok(eventService.getFullEventDetails(eventId));
    }

}
