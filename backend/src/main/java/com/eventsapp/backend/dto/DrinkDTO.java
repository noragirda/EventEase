package com.eventsapp.backend.dto;

import com.eventsapp.backend.model.enums.DrinkType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for representing a drink item.
 * <p>
 * Used to transfer drink data between the backend and frontend.
 */
@Getter
@Setter
@NoArgsConstructor
public class DrinkDTO {

    /**
     * The unique identifier of the drink.
     */
    private int id;

    /**
     * The name of the drink (e.g., Coca-Cola, Orange Juice).
     */
    private String name;

    /**
     * The type of the drink (e.g., ALCOHOLIC, NON_ALCOHOLIC).
     */
    private DrinkType drinkType;

    /**
     * Constructs a new DrinkDTO with all fields.
     *
     * @param id         the drink ID
     * @param name       the drink name
     * @param drinkType  the type of drink
     */
    public DrinkDTO(int id, String name, DrinkType drinkType) {
        this.id = id;
        this.name = name;
        this.drinkType = drinkType;
    }
}
