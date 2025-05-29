package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.model.Soup;
import java.util.List;

/**
 * Service interface for managing {@link Soup} entities.
 */
public interface SoupService {

    /**
     * Retrieves all soups.
     *
     * @return list of all soups
     */
    List<Soup> getAllSoups();

    /**
     * Retrieves a soup by its ID.
     *
     * @param id the ID of the soup
     * @return the soup with the specified ID
     * @throws RuntimeException if soup not found
     */
    Soup getSoupById(int id);

    /**
     * Creates a new soup.
     *
     * @param soup the soup to create
     * @return the created soup
     */
    Soup createSoup(Soup soup);

    /**
     * Updates an existing soup by ID.
     *
     * @param id the ID of the soup to update
     * @param soup the soup data to update
     * @return the updated soup
     * @throws RuntimeException if soup not found
     */
    Soup updateSoup(int id, Soup soup);

    /**
     * Deletes a soup by ID.
     *
     * @param id the ID of the soup to delete
     * @throws RuntimeException if soup not found
     */
    void deleteSoup(int id);
}
