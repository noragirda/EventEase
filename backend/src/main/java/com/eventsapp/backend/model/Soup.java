package com.eventsapp.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity representing a soup item that can be selected for an event menu.
 */
@Getter
@Setter
@Entity
@Table(name = "soups")
@NoArgsConstructor
@AllArgsConstructor
public class Soup {

    /**
     * Unique identifier for the soup.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Name of the soup.
     * Must be unique and not null.
     */
    @Column(unique = true, nullable = false)
    private String name;
}
