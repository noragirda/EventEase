// dto/EventUpdateRequest.java
package com.eventsapp.backend.dto;

import com.eventsapp.backend.model.Drink;
import com.eventsapp.backend.model.Fruits;
import com.eventsapp.backend.model.enums.EventType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
// EventUpdateRequest.java
@Data
public class EventUpdateRequest {
    private EventType eventType;
    private Integer finalAdultCount;        // was int
    private Integer vegetarians;            // was int
    private Integer vegans;                 // was int
    private LocalDateTime startingTime;

    private Integer menuId;                 // was int
    private List<Integer> drinkIds;         // was List<Drink>
    private List<Integer> fruitIds;         // was List<Fruits>
    private Integer miscellaneousId;        // was int
}