package com.eventsapp.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity representing an event venue.
 * Contains details such as name, description, guest capacity, services provided, and image.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "venues")
public class Venue {

    /**
     * Unique identifier for the venue.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Name of the venue.
     * Must be unique and not null.
     */
    @Column(unique = true, nullable = false)
    private String name;

    /**
     * Optional description of the venue.
     */
    @Column
    private String description;

    /**
     * Maximum number of guests the venue can accommodate.
     */
    @Column(nullable = false)
    private int guestCapacity;

    /**
     * Description of services or provisions offered by the venue.
     */
    @Column(nullable = false)
    private String providing;

    /**
     * Image filename or URL representing the venue (e.g., "venue1.jpg").
     */
    @Column(name = "image_url")
    private String imageUrl;
}
