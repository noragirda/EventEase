package com.eventsapp.backend.controller;

import com.eventsapp.backend.model.Soup;
import com.eventsapp.backend.service.impl.SoupService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing {@link Soup} entities by administrators.
 * Provides endpoints for CRUD operations on soups.
 */
@RestController
@RequestMapping("/api/admin/soups")
@CrossOrigin(origins = "http://localhost:3000")
public class SoupController {

    private final SoupService soupService;

    /**
     * Constructs a new SoupController with the provided {@link SoupService}.
     *
     * @param soupService the service used to manage soups
     */
    public SoupController(SoupService soupService) {
        this.soupService = soupService;
    }

    /**
     * Retrieves all soups from the system.
     *
     * @return a list of all {@link Soup} entities
     */
    @GetMapping
    public ResponseEntity<List<Soup>> getAllSoups() {
        return ResponseEntity.ok(soupService.getAllSoups());
    }

    /**
     * Retrieves a specific soup by its ID.
     *
     * @param id the ID of the soup to retrieve
     * @return the {@link Soup} entity
     */
    @GetMapping("/{id}")
    public ResponseEntity<Soup> getSoupById(@PathVariable int id) {
        return ResponseEntity.ok(soupService.getSoupById(id));
    }

    /**
     * Creates a new soup.
     * Only accessible to users with the ADMIN role.
     *
     * @param soup the {@link Soup} entity to create
     * @return the created soup
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Soup> createSoup(@RequestBody Soup soup) {
        return ResponseEntity.ok(soupService.createSoup(soup));
    }

    /**
     * Updates an existing soup by ID.
     * Only accessible to users with the ADMIN role.
     *
     * @param id   the ID of the soup to update
     * @param soup the updated {@link Soup} entity
     * @return the updated soup
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Soup> updateSoup(@PathVariable int id, @RequestBody Soup soup) {
        return ResponseEntity.ok(soupService.updateSoup(id, soup));
    }

    /**
     * Deletes a soup by its ID.
     * Only accessible to users with the ADMIN role.
     *
     * @param id the ID of the soup to delete
     * @return a 204 No Content response on successful deletion
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSoup(@PathVariable int id) {
        soupService.deleteSoup(id);
        return ResponseEntity.noContent().build();
    }
}
