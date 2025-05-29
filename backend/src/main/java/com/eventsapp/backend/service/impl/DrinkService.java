package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.model.Drink;

import java.util.List;

/**
 * Service interface defining operations related to Drink entities.
 */
public interface DrinkService {

    /**
     * Retrieves all drinks.
     *
     * @return a list of all Drink entities
     */
    List<Drink> getAllDrinks();

    /**
     * Retrieves a drink by its ID.
     *
     * @param id the ID of the drink
     * @return the Drink entity with the given ID
     */
    Drink getDrinkById(int id);

    /**
     * Creates a new drink.
     *
     * @param drink the Drink entity to create
     * @return the created Drink entity
     */
    Drink createDrink(Drink drink);

    /**
     * Updates an existing drink.
     *
     * @param id the ID of the drink to update
     * @param drink the Drink entity containing updated data
     * @return the updated Drink entity
     */
    Drink updateDrink(int id, Drink drink);

    /**
     * Deletes a drink by its ID.
     *
     * @param id the ID of the drink to delete
     */
    void deleteDrink(int id);
}
