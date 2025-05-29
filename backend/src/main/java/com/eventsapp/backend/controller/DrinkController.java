package com.eventsapp.backend.controller;

import com.eventsapp.backend.model.Drink;
import com.eventsapp.backend.service.impl.DrinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing drink options.
 * Allows admins to create, retrieve, update, and delete drinks.
 * Public access is granted for viewing drinks.
 */
@RestController
@RequestMapping("/api/admin/drinks")
@CrossOrigin(origins = "http://localhost:3000")
public class DrinkController {

    /**
     * Service responsible for business logic related to drinks.
     */
    private final DrinkService drinkService;

    /**
     * Constructor injection of {@link DrinkService}.
     *
     * @param drinkService the drink service
     */
    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    /**
     * Retrieves all available drinks.
     *
     * @return a list of {@link Drink} entities
     */
    @GetMapping
    public ResponseEntity<List<Drink>> getAllDrinks() {
        return ResponseEntity.ok(drinkService.getAllDrinks());
    }

    /**
     * Retrieves a specific drink by its ID.
     *
     * @param id the ID of the drink
     * @return the requested {@link Drink} entity
     */
    @GetMapping("/{id}")
    public ResponseEntity<Drink> getDrinkById(@PathVariable int id) {
        return ResponseEntity.ok(drinkService.getDrinkById(id));
    }

    /**
     * Creates a new drink. Requires admin privileges.
     *
     * @param drink the drink to be created
     * @return the created {@link Drink}
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Drink> createDrink(@RequestBody Drink drink) {
        return ResponseEntity.ok(drinkService.createDrink(drink));
    }

    /**
     * Updates an existing drink by ID. Requires admin privileges.
     *
     * @param id    the ID of the drink to update
     * @param drink the updated drink data
     * @return the updated {@link Drink}
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Drink> updateDrink(@PathVariable int id, @RequestBody Drink drink) {
        return ResponseEntity.ok(drinkService.updateDrink(id, drink));
    }

    /**
     * Deletes a drink by ID. Requires admin privileges.
     *
     * @param id the ID of the drink to delete
     * @return HTTP 204 No Content on successful deletion
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrink(@PathVariable int id) {
        drinkService.deleteDrink(id);
        return ResponseEntity.noContent().build();
    }
}
