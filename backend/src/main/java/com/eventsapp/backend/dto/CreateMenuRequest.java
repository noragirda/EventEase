package com.eventsapp.backend.dto;

import lombok.Data;

import java.util.List;

/**
 * DTO used by clients to create a custom menu for their event.
 * <p>
 * Contains lists of selected appetizer and soup IDs, and one main course ID.
 */
@Data
public class CreateMenuRequest {

    /**
     * List of selected appetizer IDs for the menu.
     */
    private List<Integer> apetizerIds;

    /**
     * List of selected soup IDs for the menu.
     */
    private List<Integer> soupIds;

    /**
     * Selected main course ID for the menu.
     */
    private Integer mainCourseId;
}
