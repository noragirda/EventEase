package com.eventsapp.backend.controller;

import com.eventsapp.backend.model.Booking;
import com.eventsapp.backend.model.enums.BookingStatus;
import com.eventsapp.backend.service.impl.BookingService;
import com.eventsapp.backend.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for admin operations on client bookings.
 * Allows viewing, approving, marking as paid, and rejecting bookings.
 */
@RestController
@RequestMapping("/api/admin/bookings")
@RequiredArgsConstructor
public class AdminBookingController {

    /**
     * Repository used to fetch booking data from the database.
     */
    private final BookingRepository bookingRepository;

    /**
     * Service layer used to handle booking approval, payment, and rejection logic.
     */
    private final BookingService bookingService;

    /**
     * Retrieves all bookings that are awaiting admin approval.
     *
     * @return a list of bookings with {@link BookingStatus#AWAITING_APPROVAL}
     */
    @GetMapping("/awaiting-approval")
    public List<Booking> getAwaitingApprovalBookings() {
        return bookingRepository.findByBookingStatus(BookingStatus.AWAITING_APPROVAL);
    }

    /**
     * Retrieves all bookings that are not yet confirmed or rejected.
     *
     * @return a list of pending bookings to be managed by the admin
     */
    @GetMapping("/manage")
    public List<Booking> getAllUnconfirmedBookings() {
        return bookingRepository.findAll().stream()
                .filter(b -> b.getBookingStatus() != BookingStatus.CONFIRMED &&
                        b.getBookingStatus() != BookingStatus.REJECTED)
                .toList();
    }

    /**
     * Approves a specific booking and creates an event from it.
     *
     * @param id the ID of the booking to approve
     * @return HTTP 200 OK response with a confirmation message
     */
    @PutMapping("/{id}/approve")
    public ResponseEntity<?> approveBooking(@PathVariable Long id) {
        bookingService.approveBooking(id);
        return ResponseEntity.ok("Booking approved and event created.");
    }

    /**
     * Marks a booking as paid.
     *
     * @param id the ID of the booking to mark as paid
     * @return HTTP 200 OK response with a confirmation message
     */
    @PutMapping("/{id}/mark-paid")
    public ResponseEntity<?> markBookingAsPaid(@PathVariable Long id) {
        bookingService.markBookingAsPaid(id);
        return ResponseEntity.ok("Booking marked as paid.");
    }

    /**
     * Rejects a specific booking.
     *
     * @param id the ID of the booking to reject
     * @return HTTP 200 OK response with a confirmation message
     */
    @PutMapping("/bookings/{id}/reject")
    public ResponseEntity<?> rejectBooking(@PathVariable Long id) {
        bookingService.rejectBooking(id);
        return ResponseEntity.ok("Booking rejected.");
    }
}
