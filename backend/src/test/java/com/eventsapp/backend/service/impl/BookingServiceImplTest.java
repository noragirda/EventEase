package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.dto.BookingRequest;
import com.eventsapp.backend.model.*;
import com.eventsapp.backend.model.enums.BookingStatus;
import com.eventsapp.backend.model.enums.PaymentStatus;
import com.eventsapp.backend.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceImplTest {

    @Mock
    private BookingRepository bookingRepository;
    @Mock
    private VenueRepository venueRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private EventRepository eventRepository;
    @Mock
    private EmailService emailService;

    @InjectMocks
    private BookingServiceImpl bookingService;

    private BookingRequest request;
    private Venue venue;
    private Client client;

    @BeforeEach
    void setup() {
        request = new BookingRequest();
        request.setVenueId(1);  // FIXED
        request.setEventDate(LocalDate.now().plusDays(15));
        request.setEstimatedGuestCount(100);
        request.setPaidSum(5000);

        venue = new Venue();
        venue.setId(1);         // FIXED
        venue.setName("Test Venue");

        client = new Client();
        client.setId(1L);        // FIXED
        client.setEmail("test@example.com");
        client.setName("Test Client");
    }

    @Test
    void testCreateBooking_Success() {
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(client));
        when(venueRepository.findById(1)).thenReturn(Optional.of(venue));

        bookingService.createBooking(request, "test@example.com");

        verify(bookingRepository).save(any(Booking.class));
    }

    @Test
    void testCreateBooking_UserNotFound() {
        when(userRepository.findByEmail("missing@example.com")).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class,
                () -> bookingService.createBooking(request, "missing@example.com"));
    }

    @Test
    void testCreateBooking_NotAClient() {
        User admin = new Admin(); // or plain User if not extending
        when(userRepository.findByEmail("admin@example.com")).thenReturn(Optional.of(admin));

        assertThrows(RuntimeException.class,
                () -> bookingService.createBooking(request, "admin@example.com"));
    }

    @Test
    void testCreateBooking_VenueNotFound() {
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(client));
        when(venueRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class,
                () -> bookingService.createBooking(request, "test@example.com"));
    }
    @Test
    void testMarkBookingAsPaid_Success() {
        Booking booking = new Booking();
        booking.setPaymentStatus(PaymentStatus.PENDING);

        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));

        bookingService.markBookingAsPaid(1L);

        assertEquals(PaymentStatus.PAID, booking.getPaymentStatus());
        assertEquals(BookingStatus.AWAITING_APPROVAL, booking.getBookingStatus());
        verify(bookingRepository).save(booking);
    }

    @Test
    void testMarkBookingAsPaid_AlreadyPaid() {
        Booking booking = new Booking();
        booking.setPaymentStatus(PaymentStatus.PAID);

        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));

        assertThrows(RuntimeException.class, () -> bookingService.markBookingAsPaid(1L));
    }
    @Test
    void testRejectBooking_Success() {
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);

        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));

        bookingService.rejectBooking(1L);

        assertEquals(BookingStatus.REJECTED, booking.getBookingStatus());
        verify(bookingRepository).save(booking);
    }
    @Test
    void testApproveBooking_Success() {
        Booking booking = new Booking();
        booking.setPaymentStatus(PaymentStatus.PAID);
        booking.setBookingStatus(BookingStatus.AWAITING_APPROVAL);
        booking.setEstimatedGuestCount(100);
        booking.setClientId(client);
        booking.setVenueId(venue);
        booking.setEventDate(Date.valueOf(LocalDate.now().plusDays(30)));
        booking.setStartingTime(LocalDate.now().plusDays(30).atTime(17, 0));


        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));

        bookingService.approveBooking(1L);

        assertEquals(BookingStatus.CONFIRMED, booking.getBookingStatus());
        verify(emailService).sendBookingApprovedEmail(any(), any(), any(), any());
        verify(eventRepository).save(any(Event.class));
        verify(bookingRepository).save(booking);
    }



}

