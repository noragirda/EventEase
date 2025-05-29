package com.eventsapp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for transferring appetizer data between layers.
 * <p>
 * Used primarily by the frontend to display or submit appetizer-related information.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApetizerDTO {

    /**
     * The unique identifier of the appetizer.
     */
    private int id;

    /**
     * The name of the appetizer.
     */
    private String name;

    /**
     * The maximum number of pieces allowed for this appetizer in a menu.
     */
    private int maxNumberOfPieces;
}
