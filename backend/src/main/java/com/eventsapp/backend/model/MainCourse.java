package com.eventsapp.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity representing a customizable main course option for an event menu.
 */
@Getter
@Setter
@Entity
@Table(name = "main_courses")
@NoArgsConstructor
@AllArgsConstructor
public class MainCourse {

    /**
     * Unique identifier of the main course.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Name of the main course (e.g., "Grilled Chicken Deluxe").
     */
    @Column(nullable = false)
    private String name;

    /**
     * Optional description of the main course.
     */
    private String description;

    /**
     * First main protein or element of the dish (e.g., "Chicken").
     */
    @Column(nullable = false)
    private String mainElement1;

    /**
     * Second main protein or element of the dish (e.g., "Bacon").
     */
    @Column(nullable = false)
    private String mainElement2;

    /**
     * Cooked vegetables served with the main course (optional).
     */
    @Column
    private String cookedVeggies;

    /**
     * Type of starches included (e.g., "Mashed Potatoes", "Rice").
     */
    @Column(nullable = false)
    private String starches;

    /**
     * Optional salad served with the dish.
     */
    @Column
    private String salads;

    /**
     * Sauce accompanying the main course (e.g., "Mushroom Sauce").
     */
    @Column(nullable = false)
    private String sauce;
}
