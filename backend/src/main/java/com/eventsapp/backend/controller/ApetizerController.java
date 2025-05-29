package com.eventsapp.backend.controller;

import com.eventsapp.backend.model.Apetizer;
import com.eventsapp.backend.service.impl.ApetizerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing appetizers.
 * Provides endpoints to create, retrieve, update, and delete appetizer items.
 * Restricted to admins for modifying operations.
 */
@RestController
@RequestMapping("/api/admin/apetizers")
@CrossOrigin(origins = "http://localhost:3000")
public class ApetizerController {

    /**
     * Service for handling appetizer-related operations.
     */
    private final ApetizerService apetizerService;

    /**
     * Constructor injection for {@link ApetizerService}.
     *
     * @param apetizerService the appetizer service
     */
    public ApetizerController(ApetizerService apetizerService) {
        this.apetizerService = apetizerService;
    }

    /**
     * Retrieves all available appetizers.
     *
     * @return a list of {@link Apetizer} entities
     */
    @GetMapping
    public ResponseEntity<List<Apetizer>> getAllApetizers() {
        return ResponseEntity.ok(apetizerService.getAllApetizers());
    }

    /**
     * Retrieves a specific appetizer by its ID.
     *
     * @param id the ID of the appetizer
     * @return the requested {@link Apetizer}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Apetizer> getApetizerById(@PathVariable int id) {
        return ResponseEntity.ok(apetizerService.getApetizerById(id));
    }

    /**
     * Creates a new appetizer. Requires admin privileges.
     *
     * @param apetizer the appetizer to create
     * @return the created {@link Apetizer}
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Apetizer> createApetizer(@RequestBody Apetizer apetizer) {
        return ResponseEntity.ok(apetizerService.createApetizer(apetizer));
    }

    /**
     * Updates an existing appetizer by ID. Requires admin privileges.
     *
     * @param id        the ID of the appetizer to update
     * @param apetizer  the updated appetizer data
     * @return the updated {@link Apetizer}
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Apetizer> updateApetizer(@PathVariable int id, @RequestBody Apetizer apetizer) {
        return ResponseEntity.ok(apetizerService.updateApetizer(id, apetizer));
    }

    /**
     * Deletes an appetizer by ID. Requires admin privileges.
     *
     * @param id the ID of the appetizer to delete
     * @return HTTP 204 No Content response if deletion is successful
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApetizer(@PathVariable int id) {
        apetizerService.deleteApetizer(id);
        return ResponseEntity.noContent().build();
    }
}
