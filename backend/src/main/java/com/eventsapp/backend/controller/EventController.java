package com.eventsapp.backend.controller;

import com.eventsapp.backend.dto.CreateMenuRequest;
import com.eventsapp.backend.dto.CreateMiscRequest;
import com.eventsapp.backend.dto.MiscellaneousRequest;
import com.eventsapp.backend.service.impl.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PutMapping("/{eventId}/menu/custom")
    public ResponseEntity<String> assignCustomMenuToEvent(@PathVariable Long eventId,
                                                          @RequestBody CreateMenuRequest request) {
        eventService.assignCustomMenu(eventId, request);
        return ResponseEntity.ok("Custom menu assigned to event.");
    }

    @PutMapping("/{eventId}/misc/custom")
    public ResponseEntity<String> assignCustomMiscToEvent(@PathVariable Long eventId,
                                                          @RequestBody CreateMiscRequest request) {
        eventService.assignCustomMisc(eventId, request);
        return ResponseEntity.ok("Custom miscellaneous assigned to event.");
    }


}
