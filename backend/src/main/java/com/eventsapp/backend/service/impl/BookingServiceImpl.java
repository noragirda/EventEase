package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.dto.BookingRequest;
import com.eventsapp.backend.model.*;
import com.eventsapp.backend.model.enums.BookingStatus;
import com.eventsapp.backend.model.enums.PaymentStatus;
import com.eventsapp.backend.repository.BookingRepository;
import com.eventsapp.backend.repository.EventRepository;
import com.eventsapp.backend.repository.UserRepository;
import com.eventsapp.backend.repository.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * Service implementation for managing bookings.
 * Handles creation, approval, payment marking, and rejection of bookings.
 */
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final VenueRepository venueRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final EmailService emailService;

    /**
     * Creates a new booking for a client identified by email.
     * Verifies client existence and venue availability.
     *
     * @param request     booking request details
     * @param clientEmail email of the client making the booking
     */
    @Override
    public void createBooking(BookingRequest request, String clientEmail) {
        User user = userRepository.findByEmail(clientEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!(user instanceof Client)) {
            throw new RuntimeException("Only clients can create bookings.");
        }
        Client client = (Client) user;

        Venue venue = venueRepository.findById(request.getVenueId())
                .orElseThrow(() -> new RuntimeException("Venue not found"));

        Booking booking = new Booking();
        booking.setClientId(client);
        booking.setVenueId(venue);
        booking.setEventDate(Date.valueOf(request.getEventDate()));
        booking.setStartingTime(LocalDateTime.of(request.getEventDate(), LocalTime.of(17, 0)));
        booking.setEstimatedGuestCount(request.getEstimatedGuestCount());
        booking.setPaidSum(request.getPaidSum());
        booking.setPaymentStatus(PaymentStatus.PENDING);
        booking.setBookingStatus(BookingStatus.PENDING);

        bookingRepository.save(booking);
    }

    /**
     * Approves a booking if it is paid and awaiting approval.
     * Updates booking status, sends notification email, and creates an event.
     *
     * @param bookingId ID of the booking to approve
     */
    @Override
    public void approveBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        if (booking.getPaymentStatus() != PaymentStatus.PAID) {
            throw new RuntimeException("Booking is not paid.");
        }

        if (booking.getBookingStatus() != BookingStatus.AWAITING_APPROVAL) {
            throw new RuntimeException("Booking is not ready for approval.");
        }

        booking.setBookingStatus(BookingStatus.CONFIRMED);
        Client client = booking.getClientId();
        String clientEmail = client.getEmail();
        String clientName = client.getName();
        String venueName = booking.getVenueId().getName();
        String date = booking.getEventDate().toString();

        emailService.sendBookingApprovedEmail(clientEmail, clientName, venueName, date);
        bookingRepository.save(booking);

        Event event = new Event();
        event.setVenue(booking.getVenueId());
        event.setEventDate(booking.getEventDate());
        event.setFinalAdultCount(booking.getEstimatedGuestCount());
        event.setClientIds(List.of(booking.getClientId()));
        event.setStartingTime(booking.getStartingTime());
        event.setCalculatedPricePerAdult(0);
        event.setCalculatedPricePerChild(0);
        event.setVegetarians(0);
        event.setVegans(0);
        event.setDrinks(null);
        event.setMenu(null);
        event.setMiscellaneous(null);
        event.setFruits(null);
        event.setEventType(null);

        eventRepository.save(event);
    }

    /**
     * Marks a booking as paid if it is not already marked.
     * Updates booking status to awaiting approval.
     *
     * @param bookingId ID of the booking to mark as paid
     */
    @Override
    public void markBookingAsPaid(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        if (booking.getPaymentStatus() == PaymentStatus.PAID) {
            throw new RuntimeException("Booking already marked as paid.");
        }

        booking.setPaymentStatus(PaymentStatus.PAID);
        booking.setBookingStatus(BookingStatus.AWAITING_APPROVAL);

        bookingRepository.save(booking);
    }

    /**
     * Rejects a booking by setting its status to REJECTED.
     *
     * @param bookingId ID of the booking to reject
     */
    @Override
    public void rejectBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setBookingStatus(BookingStatus.REJECTED);
        bookingRepository.save(booking);
    }
}
