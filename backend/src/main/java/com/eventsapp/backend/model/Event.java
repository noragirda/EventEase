package com.eventsapp.backend.model;

import com.eventsapp.backend.model.enums.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Represents a full event instance created from a booking.
 * Stores information about the event type, guest counts, associated clients,
 * menu, venue, drinks, miscellaneous options, fruits, and event timing.
 */
@Getter
@Setter
@Entity
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    /**
     * Unique identifier for the event.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Type of the event (e.g., wedding, celebration).
     */
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    /**
     * Clients participating in the event.
     */
    @ManyToMany
    @JoinTable(
            name = "event_client",
            joinColumns = @JoinColumn(name = "clients"),
            inverseJoinColumns = @JoinColumn(name = "events")
    )
    private List<Client> clientIds;

    /**
     * Date of the event.
     */
    @Column(nullable = false)
    private Date eventDate;

    /**
     * Final number of adult guests.
     */
    @Column(nullable = false)
    private int finalAdultCount;

    /**
     * Calculated price per adult.
     */
    @Column
    private int calculatedPricePerAdult;

    /**
     * Calculated price per child.
     */
    @Column
    private int calculatedPricePerChild;

    /**
     * Number of vegetarian guests.
     */
    @Column
    private int vegetarians;

    /**
     * Number of vegan guests.
     */
    @Column
    private int vegans;

    /**
     * Menu assigned to the event.
     */
    @ManyToOne
    private Menu menu;

    /**
     * Venue where the event will take place.
     */
    @ManyToOne
    private Venue venue;

    /**
     * List of selected drinks for the event.
     */
    @ManyToMany
    @JoinTable(
            name = "events_drinks",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "drink_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"event_id", "drink_id"})
    )
    private List<Drink> drinks;

    /**
     * Miscellaneous customization details (e.g., napkins, music provider).
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "miscellaneous_id")
    private Miscellaneous miscellaneous;

    /**
     * List of selected fruits for the event.
     */
    @ManyToMany
    @JoinTable(
            name = "events_fruits",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "fruit_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"event_id", "fruit_id"})
    )
    private List<Fruits> fruits;

    /**
     * Starting time of the event.
     */
    @Column(nullable = false)
    private LocalDateTime startingTime;
}
