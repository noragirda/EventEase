package com.eventsapp.backend.controller;

import com.eventsapp.backend.dto.CreateMenuRequest;
import com.eventsapp.backend.dto.CreateMiscRequest;
import com.eventsapp.backend.service.impl.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for client-side operations related to customizing their event details.
 * Allows clients to assign a custom menu or miscellaneous settings to their event.
 */
@RestController
@RequestMapping("/api/client/events")
@RequiredArgsConstructor
public class EventController {

    /**
     * Service layer for handling event customization logic.
     */
    private final EventService eventService;

    /**
     * Assigns a custom menu to the specified event.
     *
     * @param eventId the ID of the event
     * @param request the request containing selected appetizers, soups, and main course
     * @return HTTP 200 OK response with a confirmation message
     */
    @PutMapping("/{eventId}/menu/custom")
    public ResponseEntity<String> assignCustomMenuToEvent(@PathVariable Long eventId,
                                                          @RequestBody CreateMenuRequest request) {
        eventService.assignCustomMenu(eventId, request);
        return ResponseEntity.ok("Custom menu assigned to event.");
    }

    /**
     * Assigns custom miscellaneous settings (e.g., napkins color, decorations) to the event.
     *
     * @param eventId the ID of the event
     * @param request the miscellaneous options to assign
     * @return HTTP 200 OK response with a confirmation message
     */
    @PutMapping("/{eventId}/misc/custom")
    public ResponseEntity<String> assignCustomMiscToEvent(@PathVariable Long eventId,
                                                          @RequestBody CreateMiscRequest request) {
        eventService.assignCustomMisc(eventId, request);
        return ResponseEntity.ok("Custom miscellaneous assigned to event.");
    }
}
