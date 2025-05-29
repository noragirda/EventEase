package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.model.MainCourse;
import java.util.List;

/**
 * Service interface for managing MainCourse entities.
 */
public interface MainCourseService {

    /**
     * Retrieves all main courses.
     *
     * @return a list of all main courses
     */
    List<MainCourse> getAllMainCourses();

    /**
     * Retrieves a main course by its ID.
     *
     * @param id the ID of the main course
     * @return the main course with the specified ID
     * @throws RuntimeException if the main course is not found
     */
    MainCourse getMainCourseById(int id);

    /**
     * Creates a new main course.
     *
     * @param mainCourse the main course to create
     * @return the created main course
     */
    MainCourse createMainCourse(MainCourse mainCourse);

    /**
     * Updates an existing main course by ID.
     *
     * @param id the ID of the main course to update
     * @param mainCourse the main course data to update
     * @return the updated main course
     * @throws RuntimeException if the main course is not found
     */
    MainCourse updateMainCourse(int id, MainCourse mainCourse);

    /**
     * Deletes a main course by ID.
     *
     * @param id the ID of the main course to delete
     * @throws RuntimeException if the main course is not found
     */
    void deleteMainCourse(int id);
}
