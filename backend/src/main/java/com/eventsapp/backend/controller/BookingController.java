package com.eventsapp.backend.controller;

import com.eventsapp.backend.dto.BookingRequest;
import com.eventsapp.backend.service.impl.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * REST controller for handling booking operations initiated by clients.
 * Allows clients to create event bookings.
 */
@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    /**
     * Service for managing booking logic.
     */
    private final BookingService bookingService;

    /**
     * Creates a new booking for the currently authenticated client.
     *
     * @param request   the booking details (venue, date, guests, etc.)
     * @param principal the authenticated user's security context (email is extracted)
     * @return HTTP 200 OK with a success message if the booking is created
     */
    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody BookingRequest request, Principal principal) {
        bookingService.createBooking(request, principal.getName());
        return ResponseEntity.ok("Booking created successfully.");
    }
}
