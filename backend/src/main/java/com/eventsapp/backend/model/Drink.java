package com.eventsapp.backend.model;

import com.eventsapp.backend.model.enums.DrinkType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity representing a drink item.
 * Each drink has a unique name and a specified {@link DrinkType} (e.g., alcoholic or non-alcoholic).
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "drinks")
public class Drink {

    /**
     * Unique identifier for the drink.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Name of the drink. Must be unique and not null.
     */
    @Column(unique = true, nullable = false)
    private String name;

    /**
     * Type of the drink, such as alcoholic or non-alcoholic.
     */
    @Enumerated(EnumType.STRING)
    private DrinkType drinkType;

}
