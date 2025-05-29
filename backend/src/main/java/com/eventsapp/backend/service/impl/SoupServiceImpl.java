package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.model.Soup;
import com.eventsapp.backend.repository.SoupRepository;
import com.eventsapp.backend.service.impl.SoupService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for managing {@link Soup} entities.
 */
@Service
public class SoupServiceImpl implements SoupService {

    private final SoupRepository soupRepository;

    /**
     * Constructs a new SoupServiceImpl with the given repository.
     *
     * @param soupRepository the repository to access Soup data
     */
    public SoupServiceImpl(SoupRepository soupRepository) {
        this.soupRepository = soupRepository;
    }

    /**
     * Retrieves all soups.
     *
     * @return a list of all soups
     */
    @Override
    public List<Soup> getAllSoups() {
        return soupRepository.findAll();
    }

    /**
     * Retrieves a soup by its ID.
     *
     * @param id the ID of the soup
     * @return the soup with the specified ID
     * @throws RuntimeException if no soup is found with the given ID
     */
    @Override
    public Soup getSoupById(int id) {
        return soupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Soup not found with ID: " + id));
    }

    /**
     * Creates a new soup.
     *
     * @param soup the soup to create
     * @return the created soup
     */
    @Override
    public Soup createSoup(Soup soup) {
        return soupRepository.save(soup);
    }

    /**
     * Updates an existing soup by ID.
     *
     * @param id          the ID of the soup to update
     * @param updatedSoup the new soup data
     * @return the updated soup
     * @throws RuntimeException if no soup is found with the given ID
     */
    @Override
    public Soup updateSoup(int id, Soup updatedSoup) {
        Soup existing = getSoupById(id);
        existing.setName(updatedSoup.getName());
        return soupRepository.save(existing);
    }

    /**
     * Deletes a soup by ID.
     *
     * @param id the ID of the soup to delete
     * @throws RuntimeException if no soup is found with the given ID
     */
    @Override
    public void deleteSoup(int id) {
        if (!soupRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Soup not found with ID: " + id);
        }
        soupRepository.deleteById(id);
    }
}
