package com.eventsapp.backend.dto;

import com.eventsapp.backend.model.enums.EventType;
import com.eventsapp.backend.model.enums.NapkinsColors;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class FullEventDetailsResponse {
    private Long eventId;
    private EventType eventType;
    private Date eventDate;
    private LocalDateTime startingTime;
    private int finalAdultCount;
    private int calculatedPricePerAdult;
    private int calculatedPricePerChild;
    private int vegetarians;
    private int vegans;

    // Menu
    private List<String> apetizers;
    private List<String> soups;
    private String mainCourse;

    // Miscellaneous
    private NapkinsColors napkinsColor;
    private boolean flowerDecoration;
    private boolean candyBar;
    private boolean photoCorner;
    private String musicProvider;
    private String cakeProvider;
    private String candyProvider;

    // Drinks & Fruits
    private List<String> drinks;
    private List<String> fruits;
}
