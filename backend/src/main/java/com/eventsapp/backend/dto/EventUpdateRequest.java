package com.eventsapp.backend.dto;

import com.eventsapp.backend.model.enums.EventType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Data Transfer Object (DTO) for updating event details by the client.
 * <p>
 * This class encapsulates editable fields for an event such as type, guest count, dietary preferences,
 * starting time, and selections for menu, drinks, fruits, and miscellaneous options.
 */
@Getter
@Setter
@Data
public class EventUpdateRequest {

    /**
     * The type of the event (e.g., WEDDING, BIRTHDAY, CORPORATE).
     */
    private EventType eventType;

    /**
     * The final confirmed number of adult guests.
     */
    private Integer finalAdultCount;

    /**
     * The number of vegetarian guests.
     */
    private Integer vegetarians;

    /**
     * The number of vegan guests.
     */
    private Integer vegans;

    /**
     * The starting date and time of the event.
     */
    private LocalDateTime startingTime;

    /**
     * The ID of the menu selected for the event.
     */
    private Integer menuId;

    /**
     * A list of drink IDs selected for the event.
     */
    private List<Integer> drinkIds;

    /**
     * A list of fruit IDs selected for the event.
     */
    private List<Integer> fruitIds;

    /**
     * The ID of the miscellaneous options selected for the event (e.g., decorations, cake).
     */
    private Integer miscellaneousId;
}
