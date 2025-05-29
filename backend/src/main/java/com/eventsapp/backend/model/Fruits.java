package com.eventsapp.backend.model;

import com.eventsapp.backend.model.enums.FruitTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity representing a type of fruit that can be selected for an event.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fruits")
public class Fruits {

    /**
     * Unique identifier for the fruit.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Display name of the fruit (e.g., "Apples", "Bananas").
     */
    @Column(unique = true, nullable = false)
    private String name;

    /**
     * Enum value representing the standardized type of fruit.
     */
    @Enumerated(EnumType.STRING)
    private FruitTypes fruitTypes;
}
