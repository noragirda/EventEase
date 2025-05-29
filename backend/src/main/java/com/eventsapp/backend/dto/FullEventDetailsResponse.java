package com.eventsapp.backend.dto;

import com.eventsapp.backend.model.enums.EventType;
import com.eventsapp.backend.model.enums.NapkinsColors;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * DTO representing the full details of an event for display purposes.
 * <p>
 * This response aggregates all relevant information related to a specific event,
 * including general details, menu selections, miscellaneous choices, and drink/fruit preferences.
 */
@Data
public class FullEventDetailsResponse {

    /** Unique identifier for the event. */
    private Long eventId;

    /** The type of the event (e.g., WEDDING, BIRTHDAY, CORPORATE). */
    private EventType eventType;

    /** The calendar date on which the event takes place. */
    private Date eventDate;

    /** The time the event starts. */
    private LocalDateTime startingTime;

    /** Final confirmed count of adult guests attending the event. */
    private int finalAdultCount;

    /** Price calculated per adult guest. */
    private int calculatedPricePerAdult;

    /** Price calculated per child guest. */
    private int calculatedPricePerChild;

    /** Number of vegetarian guests. */
    private int vegetarians;

    /** Number of vegan guests. */
    private int vegans;

    // -------------------- MENU DETAILS --------------------

    /** List of appetizer names selected for the event. */
    private List<String> apetizers;

    /** List of soup names selected for the event. */
    private List<String> soups;

    /** Name of the selected main course. */
    private String mainCourse;

    // -------------------- MISCELLANEOUS OPTIONS --------------------

    /** Color selected for napkins (enum). */
    private NapkinsColors napkinsColor;

    /** Indicates whether flower decoration is included. */
    private boolean flowerDecoration;

    /** Indicates whether a candy bar is included. */
    private boolean candyBar;

    /** Indicates whether a photo corner is included. */
    private boolean photoCorner;

    /** The name of the music provider (e.g., DJ, band). */
    private String musicProvider;

    /** The name of the cake provider. */
    private String cakeProvider;

    /** The name of the candy provider. */
    private String candyProvider;

    // -------------------- DRINKS & FRUITS --------------------

    /** List of drink names selected for the event. */
    private List<String> drinks;

    /** List of fruit names selected for the event. */
    private List<String> fruits;
}
