package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.model.Drink;
import com.eventsapp.backend.repository.DrinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for managing {@link Drink} entities.
 * Provides CRUD operations by interacting with the {@link DrinkRepository}.
 */
@Service
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository drinkRepository;

    /**
     * Constructs the service with the specified DrinkRepository.
     *
     * @param drinkRepository the repository to interact with drink data
     */
    public DrinkServiceImpl(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    /**
     * Retrieves all drinks.
     *
     * @return a list of all Drink entities
     */
    @Override
    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    /**
     * Retrieves a drink by its ID.
     *
     * @param id the ID of the drink
     * @return the Drink entity with the given ID
     * @throws RuntimeException if no drink is found with the given ID
     */
    @Override
    public Drink getDrinkById(int id) {
        return drinkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Drink not found with ID: " + id));
    }

    /**
     * Creates a new drink.
     *
     * @param drink the Drink entity to create
     * @return the created Drink entity
     */
    @Override
    public Drink createDrink(Drink drink) {
        return drinkRepository.save(drink);
    }

    /**
     * Updates an existing drink.
     *
     * @param id           the ID of the drink to update
     * @param updatedDrink the Drink entity containing updated data
     * @return the updated Drink entity
     */
    @Override
    public Drink updateDrink(int id, Drink updatedDrink) {
        Drink existing = getDrinkById(id);
        existing.setName(updatedDrink.getName());
        existing.setDrinkType(updatedDrink.getDrinkType());
        return drinkRepository.save(existing);
    }

    /**
     * Deletes a drink by its ID.
     *
     * @param id the ID of the drink to delete
     * @throws RuntimeException if the drink does not exist
     */
    @Override
    public void deleteDrink(int id) {
        if (!drinkRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Drink not found with ID: " + id);
        }
        drinkRepository.deleteById(id);
    }
}
