package com.eventsapp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object representing a main course item.
 * <p>
 * This DTO is used to transfer detailed information about a main course dish,
 * including its ingredients and description, between the backend and frontend.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MainCourseDTO {

    /** The unique identifier of the main course. */
    private int id;

    /** The name of the main course. */
    private String name;

    /** A brief description of the dish. */
    private String description;

    /** The first primary element (e.g., type of meat or main protein). */
    private String mainElement1;

    /** The second primary element (e.g., optional additional protein or special ingredient). */
    private String mainElement2;

    /** Cooked vegetables included in the dish. */
    private String cookedVeggies;

    /** Starches included in the dish (e.g., potatoes, rice). */
    private String starches;

    /** Salads included as part of the main course. */
    private String salads;

    /** Sauce or dressing served with the dish. */
    private String sauce;
}
