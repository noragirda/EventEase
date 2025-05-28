package com.eventsapp.backend.controller;

import com.eventsapp.backend.model.Soup;
import com.eventsapp.backend.service.impl.SoupService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/soups")
@CrossOrigin(origins = "http://localhost:3000")
public class SoupController {

    private final SoupService soupService;

    public SoupController(SoupService soupService) {
        this.soupService = soupService;
    }

    @GetMapping
    public ResponseEntity<List<Soup>> getAllSoups() {
        return ResponseEntity.ok(soupService.getAllSoups());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Soup> getSoupById(@PathVariable int id) {
        return ResponseEntity.ok(soupService.getSoupById(id));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Soup> createSoup(@RequestBody Soup soup) {
        return ResponseEntity.ok(soupService.createSoup(soup));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Soup> updateSoup(@PathVariable int id, @RequestBody Soup soup) {
        return ResponseEntity.ok(soupService.updateSoup(id, soup));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSoup(@PathVariable int id) {
        soupService.deleteSoup(id);
        return ResponseEntity.noContent().build();
    }
}
