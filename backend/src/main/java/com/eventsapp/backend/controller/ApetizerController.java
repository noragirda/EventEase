package com.eventsapp.backend.controller;

import com.eventsapp.backend.model.Apetizer;
import com.eventsapp.backend.service.impl.ApetizerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/apetizers")
@CrossOrigin(origins = "http://localhost:3000")
public class ApetizerController {

    private final ApetizerService apetizerService;

    public ApetizerController(ApetizerService apetizerService) {
        this.apetizerService = apetizerService;
    }

    @GetMapping
    public ResponseEntity<List<Apetizer>> getAllApetizers() {
        return ResponseEntity.ok(apetizerService.getAllApetizers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apetizer> getApetizerById(@PathVariable int id) {
        return ResponseEntity.ok(apetizerService.getApetizerById(id));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Apetizer> createApetizer(@RequestBody Apetizer apetizer) {
        return ResponseEntity.ok(apetizerService.createApetizer(apetizer));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Apetizer> updateApetizer(@PathVariable int id, @RequestBody Apetizer apetizer) {
        return ResponseEntity.ok(apetizerService.updateApetizer(id, apetizer));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApetizer(@PathVariable int id) {
        apetizerService.deleteApetizer(id);
        return ResponseEntity.noContent().build();
    }
}
