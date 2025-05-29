package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.model.Apetizer;

import java.util.List;

/**
 * Service interface defining operations related to Apetizer entities.
 */
public interface ApetizerService {

    /**
     * Retrieves all appetizers.
     *
     * @return a list of all Apetizer entities
     */
    List<Apetizer> getAllApetizers();

    /**
     * Retrieves an appetizer by its unique identifier.
     *
     * @param id the ID of the appetizer
     * @return the Apetizer entity with the given ID
     */
    Apetizer getApetizerById(int id);

    /**
     * Creates a new appetizer.
     *
     * @param apetizer the Apetizer entity to create
     * @return the created Apetizer entity
     */
    Apetizer createApetizer(Apetizer apetizer);

    /**
     * Updates an existing appetizer.
     *
     * @param id the ID of the appetizer to update
     * @param apetizer the Apetizer entity containing updated data
     * @return the updated Apetizer entity
     */
    Apetizer updateApetizer(int id, Apetizer apetizer);

    /**
     * Deletes an appetizer by its ID.
     *
     * @param id the ID of the appetizer to delete
     */
    void deleteApetizer(int id);
}
