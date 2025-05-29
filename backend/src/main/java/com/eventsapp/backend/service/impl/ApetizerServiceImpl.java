package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.model.Apetizer;
import com.eventsapp.backend.repository.ApetizerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for managing {@link Apetizer} entities.
 * Provides CRUD operations by interacting with the {@link ApetizerRepository}.
 */
@Service
public class ApetizerServiceImpl implements ApetizerService {

    private final ApetizerRepository apetizerRepository;

    /**
     * Constructs the service with the specified ApetizerRepository.
     *
     * @param apetizerRepository the repository to interact with appetizer data
     */
    public ApetizerServiceImpl(ApetizerRepository apetizerRepository) {
        this.apetizerRepository = apetizerRepository;
    }

    /**
     * Retrieves all appetizers.
     *
     * @return a list of all Apetizer entities
     */
    @Override
    public List<Apetizer> getAllApetizers() {
        return apetizerRepository.findAll();
    }

    /**
     * Retrieves an appetizer by its ID.
     *
     * @param id the ID of the appetizer
     * @return the Apetizer entity with the given ID
     * @throws RuntimeException if no appetizer is found
     */
    @Override
    public Apetizer getApetizerById(int id) {
        return apetizerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Apetizer not found with ID: " + id));
    }

    /**
     * Creates a new appetizer.
     *
     * @param apetizer the Apetizer entity to create
     * @return the created Apetizer entity
     */
    @Override
    public Apetizer createApetizer(Apetizer apetizer) {
        return apetizerRepository.save(apetizer);
    }

    /**
     * Updates an existing appetizer.
     *
     * @param id the ID of the appetizer to update
     * @param updated the Apetizer entity containing updated data
     * @return the updated Apetizer entity
     */
    @Override
    public Apetizer updateApetizer(int id, Apetizer updated) {
        Apetizer existing = getApetizerById(id);
        existing.setName(updated.getName());
        existing.setMaxNumberOfPieces(updated.getMaxNumberOfPieces());
        return apetizerRepository.save(existing);
    }

    /**
     * Deletes an appetizer by its ID.
     *
     * @param id the ID of the appetizer to delete
     * @throws RuntimeException if the appetizer does not exist
     */
    @Override
    public void deleteApetizer(int id) {
        if (!apetizerRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Apetizer not found with ID: " + id);
        }
        apetizerRepository.deleteById(id);
    }
}
