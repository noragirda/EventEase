package com.eventsapp.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Abstract base class representing a generic food item with common properties.
 * Intended to be extended by specific food entities (e.g., Appetizer, Soup, MainCourse).
 */
@Getter
@Setter
@Entity
@Table(name = "foods")
@NoArgsConstructor
@AllArgsConstructor
public abstract class Food {

    /**
     * Unique identifier for the food item.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Price of the food item.
     */
    @Column(nullable = false)
    private int price;
}
