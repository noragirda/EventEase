package com.eventsapp.backend.controller;

import com.eventsapp.backend.config.JwtUtil;
import com.eventsapp.backend.dto.UserResponse;
import com.eventsapp.backend.dto.VenueRequest;
import com.eventsapp.backend.dto.VenueResponse;
import com.eventsapp.backend.mapper.VenueMapper;
import com.eventsapp.backend.model.Event;
import com.eventsapp.backend.model.Venue;
import com.eventsapp.backend.repository.EventRepository;
import com.eventsapp.backend.service.impl.ImageService;
import com.eventsapp.backend.service.impl.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/admin/venues")
@RequiredArgsConstructor
public class AdminVenueController {

    private final VenueService venueService;
    private final JwtUtil jwtUtil;
    private final EventRepository eventRepository;

    @GetMapping
    public ResponseEntity<List<VenueResponse>> getAllVenues() {
        return ResponseEntity.ok(venueService.getAllVenues());
    }

    @PostMapping("")
    public ResponseEntity<VenueResponse> createVenue(
            @RequestPart("data") VenueRequest request,
            @RequestPart(value = "image", required = false) MultipartFile image) {
        return ResponseEntity.ok(venueService.createVenue(request, image));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VenueResponse> updateVenue(
            @PathVariable int id,
            @RequestPart("data") VenueRequest request,
            @RequestPart(value = "image", required = false) MultipartFile image) {
        return ResponseEntity.ok(venueService.updateVenue(id, request, image));
    }
    @GetMapping("/{venueId}/available-admins")
    public ResponseEntity<List<UserResponse>> getAvailableAdmins(@PathVariable int venueId) {
        return ResponseEntity.ok(venueService.getAvailableAdminsForVenue(venueId));
    }

    @PostMapping("/{venueId}/assign-admins")
    public ResponseEntity<Void> assignAdminsToVenue(
            @PathVariable int venueId,
            @RequestBody List<Long> adminIds) {
        venueService.assignAdminsToVenue(venueId, adminIds);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/my-venues")
    public ResponseEntity<List<VenueResponse>> getMyVenues(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", ""); // Strip Bearer prefix
        String adminEmail = jwtUtil.extractUsername(token); // ✅ Extract email (subject)
        return ResponseEntity.ok(venueService.getVenuesForAdmin(adminEmail));
    }
    @GetMapping("/venue/{venueId}/events")
    public ResponseEntity<List<Event>> getEventsForVenue(@PathVariable int venueId) {
        return ResponseEntity.ok(eventRepository.findByVenueId(venueId));
    }





}
