package com.eventsapp.backend.controller;

import com.eventsapp.backend.model.Apetizer;
import com.eventsapp.backend.model.MainCourse;
import com.eventsapp.backend.model.Soup;
import com.eventsapp.backend.repository.ApetizerRepository;
import com.eventsapp.backend.repository.MainCourseRepository;
import com.eventsapp.backend.repository.SoupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for clients to view available menu items.
 * Provides access to all appetizers, soups, and main courses.
 */
@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class MenuItemController {

    /**
     * Repository for fetching appetizer data.
     */
    private final ApetizerRepository apetizerRepository;

    /**
     * Repository for fetching soup data.
     */
    private final SoupRepository soupRepository;

    /**
     * Repository for fetching main course data.
     */
    private final MainCourseRepository mainCourseRepository;

    /**
     * Retrieves all available appetizers from the system.
     *
     * @return a list of {@link Apetizer} entities
     */
    @GetMapping("/apetizers")
    public List<Apetizer> getAllApetizers() {
        return apetizerRepository.findAll();
    }

    /**
     * Retrieves all available soups from the system.
     *
     * @return a list of {@link Soup} entities
     */
    @GetMapping("/soups")
    public List<Soup> getAllSoups() {
        return soupRepository.findAll();
    }

    /**
     * Retrieves all available main courses from the system.
     *
     * @return a list of {@link MainCourse} entities
     */
    @GetMapping("/main-courses")
    public List<MainCourse> getAllMainCourses() {
        return mainCourseRepository.findAll();
    }
}
