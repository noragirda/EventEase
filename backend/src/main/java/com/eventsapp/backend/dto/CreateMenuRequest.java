package com.eventsapp.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateMenuRequest {
    private List<Integer> apetizerIds;
    private List<Integer> soupIds;
    private Integer mainCourseId;
}
