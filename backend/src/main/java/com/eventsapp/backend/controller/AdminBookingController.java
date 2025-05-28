package com.eventsapp.backend.controller;

import com.eventsapp.backend.model.Booking;
import com.eventsapp.backend.model.enums.BookingStatus;
import com.eventsapp.backend.service.impl.BookingService;
import com.eventsapp.backend.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/bookings")
@RequiredArgsConstructor
public class AdminBookingController {

    private final BookingRepository bookingRepository;
    private final BookingService bookingService;

    @GetMapping("/awaiting-approval")
    public List<Booking> getAwaitingApprovalBookings() {
        return bookingRepository.findByBookingStatus(BookingStatus.AWAITING_APPROVAL);
    }
    @GetMapping("/manage")
    public List<Booking> getAllUnconfirmedBookings() {
        return bookingRepository.findAll().stream()
                .filter(b -> b.getBookingStatus() != BookingStatus.CONFIRMED && b.getBookingStatus() != BookingStatus.REJECTED)
                .toList();
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<?> approveBooking(@PathVariable Long id) {
        bookingService.approveBooking(id);
        return ResponseEntity.ok("Booking approved and event created.");
    }
    @PutMapping("/{id}/mark-paid")
    public ResponseEntity<?> markBookingAsPaid(@PathVariable Long id) {
        bookingService.markBookingAsPaid(id);
        return ResponseEntity.ok("Booking marked as paid.");
    }
    @PutMapping("/bookings/{id}/reject")
    public ResponseEntity<?> rejectBooking(@PathVariable Long id) {
        bookingService.rejectBooking(id);
        return ResponseEntity.ok("Booking rejected.");
    }


}
