package com.eventsapp.backend.controller;

import com.eventsapp.backend.config.JwtUtil;
import com.eventsapp.backend.dto.UserResponse;
import com.eventsapp.backend.dto.VenueRequest;
import com.eventsapp.backend.dto.VenueResponse;
import com.eventsapp.backend.model.Event;
import com.eventsapp.backend.repository.EventRepository;
import com.eventsapp.backend.service.impl.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * REST controller for managing venues by administrators.
 * Supports creation, editing, assignment of admins, and retrieval of venue data and related events.
 */
@RestController
@RequestMapping("/api/admin/venues")
@RequiredArgsConstructor
public class AdminVenueController {

    /**
     * Service handling venue-related operations.
     */
    private final VenueService venueService;

    /**
     * Utility class for extracting information from JWT tokens.
     */
    private final JwtUtil jwtUtil;

    /**
     * Repository for accessing event data.
     */
    private final EventRepository eventRepository;

    /**
     * Retrieves all venues in the system.
     *
     * @return a list of {@link VenueResponse} objects
     */
    @GetMapping
    public ResponseEntity<List<VenueResponse>> getAllVenues() {
        return ResponseEntity.ok(venueService.getAllVenues());
    }

    /**
     * Creates a new venue with optional image upload.
     *
     * @param request the venue data
     * @param image   an optional image file for the venue
     * @return the created {@link VenueResponse}
     */
    @PostMapping("")
    public ResponseEntity<VenueResponse> createVenue(
            @RequestPart("data") VenueRequest request,
            @RequestPart(value = "image", required = false) MultipartFile image) {
        return ResponseEntity.ok(venueService.createVenue(request, image));
    }

    /**
     * Updates an existing venue by ID, with optional image replacement.
     *
     * @param id      the ID of the venue to update
     * @param request the updated venue data
     * @param image   an optional new image
     * @return the updated {@link VenueResponse}
     */
    @PutMapping("/{id}")
    public ResponseEntity<VenueResponse> updateVenue(
            @PathVariable int id,
            @RequestPart("data") VenueRequest request,
            @RequestPart(value = "image", required = false) MultipartFile image) {
        return ResponseEntity.ok(venueService.updateVenue(id, request, image));
    }

    /**
     * Retrieves a list of available admins who can be assigned to the given venue.
     *
     * @param venueId the ID of the venue
     * @return a list of {@link UserResponse} representing available admins
     */
    @GetMapping("/{venueId}/available-admins")
    public ResponseEntity<List<UserResponse>> getAvailableAdmins(@PathVariable int venueId) {
        return ResponseEntity.ok(venueService.getAvailableAdminsForVenue(venueId));
    }

    /**
     * Assigns a list of admin users to a venue.
     *
     * @param venueId  the ID of the venue
     * @param adminIds the list of admin user IDs to assign
     * @return HTTP 200 OK response upon successful assignment
     */
    @PostMapping("/{venueId}/assign-admins")
    public ResponseEntity<Void> assignAdminsToVenue(
            @PathVariable int venueId,
            @RequestBody List<Long> adminIds) {
        venueService.assignAdminsToVenue(venueId, adminIds);
        return ResponseEntity.ok().build();
    }

    /**
     * Retrieves the list of venues assigned to the currently authenticated admin.
     *
     * @param authHeader the Authorization header containing the JWT token
     * @return a list of {@link VenueResponse} representing venues managed by the admin
     */
    @GetMapping("/my-venues")
    public ResponseEntity<List<VenueResponse>> getMyVenues(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        String adminEmail = jwtUtil.extractUsername(token);
        return ResponseEntity.ok(venueService.getVenuesForAdmin(adminEmail));
    }

    /**
     * Retrieves all events scheduled at a specific venue.
     *
     * @param venueId the ID of the venue
     * @return a list of {@link Event} instances scheduled for the venue
     */
    @GetMapping("/venue/{venueId}/events")
    public ResponseEntity<List<Event>> getEventsForVenue(@PathVariable int venueId) {
        return ResponseEntity.ok(eventRepository.findByVenueId(venueId));
    }
}
