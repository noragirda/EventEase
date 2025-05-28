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

@Getter
@Setter
@Entity
@Table(name="bookings")
@NoArgsConstructor
@AllArgsConstructor
public class Booking
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client clientId;
    @ManyToOne
    private Venue venueId;
    @Column(nullable = false)
    private Date eventDate;
    @Column(nullable = false)
    private LocalDateTime startingTime;
    @Column(nullable = false)
    private int estimatedGuestCount;
    @Column(nullable = false)
    private int paidSum;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus = BookingStatus.PENDING;

}
