package com.eventsapp.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity representing an appetizer item that can be selected for a menu.
 */
@Getter
@Setter
@Entity
@Table(name = "apetizers")
@NoArgsConstructor
@AllArgsConstructor
public class Apetizer {

    /**
     * Unique identifier for the appetizer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The name of the appetizer.
     * Must be unique and not null.
     */
    @Column(unique = true, nullable = false)
    private String name;

    /**
     * Maximum number of pieces allowed per serving.
     */
    @Column
    private int maxNumberOfPieces;
}
