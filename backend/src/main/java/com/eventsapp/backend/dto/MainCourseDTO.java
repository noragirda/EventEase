package com.eventsapp.backend.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MainCourseDTO {
    private int id;
    private String name;
    private String description;
    private String mainElement1;
    private String mainElement2;
    private String cookedVeggies;
    private String starches;
    private String salads;
    private String sauce;

}