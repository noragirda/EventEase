package com.eventsapp.backend.model;

import com.eventsapp.backend.model.enums.BookingStatus;
import com.eventsapp.backend.model.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.time.LocalDateTime;

/**
 * Entity representing a client's booking request for a specific venue and event date.
 */
@Getter
@Setter
@Entity
@Table(name = "bookings")
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    /**
     * Unique identifier for the booking.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The client who made the booking.
     */
    @ManyToOne
    private Client clientId;

    /**
     * The venue associated with the booking.
     */
    @ManyToOne
    private Venue venueId;

    /**
     * The calendar date of the booked event.
     */
    @Column(nullable = false)
    private Date eventDate;

    /**
     * The exact starting time of the event.
     */
    @Column(nullable = false)
    private LocalDateTime startingTime;

    /**
     * The estimated number of guests for the event.
     */
    @Column(nullable = false)
    private int estimatedGuestCount;

    /**
     * The amount paid by the client for the booking.
     */
    @Column(nullable = false)
    private int paidSum;

    /**
     * Current payment status of the booking (e.g., PENDING, PAID, FAILED).
     */
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    /**
     * Current booking status (e.g., PENDING, CONFIRMED, REJECTED).
     */
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus = BookingStatus.PENDING;
}
