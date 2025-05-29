package com.eventsapp.backend.controller;

import com.eventsapp.backend.model.MainCourse;
import com.eventsapp.backend.service.impl.MainCourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing main course options in the menu.
 * Allows admins to create, retrieve, update, and delete main course entries.
 */
@RestController
@RequestMapping("/api/admin/main-courses")
@CrossOrigin(origins = "http://localhost:3000")
public class MainCourseController {

    /**
     * Service for handling business logic related to main courses.
     */
    private final MainCourseService mainCourseService;

    /**
     * Constructor injection for {@link MainCourseService}.
     *
     * @param mainCourseService the main course service
     */
    public MainCourseController(MainCourseService mainCourseService) {
        this.mainCourseService = mainCourseService;
    }

    /**
     * Retrieves all available main courses.
     *
     * @return a list of {@link MainCourse} objects
     */
    @GetMapping
    public ResponseEntity<List<MainCourse>> getAllMainCourses() {
        return ResponseEntity.ok(mainCourseService.getAllMainCourses());
    }

    /**
     * Retrieves a specific main course by its ID.
     *
     * @param id the ID of the main course
     * @return the requested {@link MainCourse}
     */
    @GetMapping("/{id}")
    public ResponseEntity<MainCourse> getMainCourseById(@PathVariable int id) {
        return ResponseEntity.ok(mainCourseService.getMainCourseById(id));
    }

    /**
     * Creates a new main course entry. Requires admin privileges.
     *
     * @param mainCourse the main course to create
     * @return the created {@link MainCourse}
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<MainCourse> createMainCourse(@RequestBody MainCourse mainCourse) {
        return ResponseEntity.ok(mainCourseService.createMainCourse(mainCourse));
    }

    /**
     * Updates an existing main course by ID. Requires admin privileges.
     *
     * @param id         the ID of the main course to update
     * @param mainCourse the updated main course data
     * @return the updated {@link MainCourse}
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<MainCourse> updateMainCourse(@PathVariable int id, @RequestBody MainCourse mainCourse) {
        return ResponseEntity.ok(mainCourseService.updateMainCourse(id, mainCourse));
    }

    /**
     * Deletes a main course by ID. Requires admin privileges.
     *
     * @param id the ID of the main course to delete
     * @return HTTP 204 No Content on successful deletion
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMainCourse(@PathVariable int id) {
        mainCourseService.deleteMainCourse(id);
        return ResponseEntity.noContent().build();
    }
}
