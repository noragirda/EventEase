package com.eventsapp.backend.controller;

import com.eventsapp.backend.model.Drink;
import com.eventsapp.backend.service.impl.DrinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/drinks")
@CrossOrigin(origins = "http://localhost:3000")
public class DrinkController {

    private final DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping
    public ResponseEntity<List<Drink>> getAllDrinks() {
        return ResponseEntity.ok(drinkService.getAllDrinks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drink> getDrinkById(@PathVariable int id) {
        return ResponseEntity.ok(drinkService.getDrinkById(id));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Drink> createDrink(@RequestBody Drink drink) {
        return ResponseEntity.ok(drinkService.createDrink(drink));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Drink> updateDrink(@PathVariable int id, @RequestBody Drink drink) {
        return ResponseEntity.ok(drinkService.updateDrink(id, drink));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrink(@PathVariable int id) {
        drinkService.deleteDrink(id);
        return ResponseEntity.noContent().build();
    }
}
