package com.eventsapp.backend.controller;

import com.eventsapp.backend.dto.BookingRequest;
import com.eventsapp.backend.service.impl.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody BookingRequest request, Principal principal) {
        bookingService.createBooking(request, principal.getName());
        return ResponseEntity.ok("Booking created successfully.");
    }
}
