package com.eventsapp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object for transferring soup data between backend and frontend.
 * <p>
 * This class contains minimal soup information used primarily for administrative
 * and menu-related operations.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SoupDTO {

    /** Unique identifier of the soup. */
    private int id;

    /** Name of the soup. */
    private String name;
}
