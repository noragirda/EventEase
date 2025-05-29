package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.exception.ResourceNotFoundException;
import com.eventsapp.backend.model.MainCourse;
import com.eventsapp.backend.repository.MainCourseRepository;
import com.eventsapp.backend.service.impl.MainCourseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for managing {@link MainCourse} entities.
 */
@Service
public class MainCourseServiceImpl implements MainCourseService {

    private final MainCourseRepository mainCourseRepository;

    /**
     * Constructs a new MainCourseServiceImpl with the given repository.
     *
     * @param mainCourseRepository the repository to access MainCourse data
     */
    public MainCourseServiceImpl(MainCourseRepository mainCourseRepository) {
        this.mainCourseRepository = mainCourseRepository;
    }

    /**
     * Retrieves all main courses.
     *
     * @return a list of all main courses
     */
    @Override
    public List<MainCourse> getAllMainCourses() {
        return mainCourseRepository.findAll();
    }

    /**
     * Retrieves a main course by its ID.
     *
     * @param id the ID of the main course
     * @return the main course with the specified ID
     * @throws ResourceNotFoundException if no main course is found with the given ID
     */
    @Override
    public MainCourse getMainCourseById(int id) {
        return mainCourseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Main course not found with id: " + id));
    }

    /**
     * Creates a new main course.
     *
     * @param mainCourse the main course to create
     * @return the created main course
     */
    @Override
    public MainCourse createMainCourse(MainCourse mainCourse) {
        return mainCourseRepository.save(mainCourse);
    }

    /**
     * Updates an existing main course by ID.
     *
     * @param id            the ID of the main course to update
     * @param updatedCourse the new main course data
     * @return the updated main course
     * @throws ResourceNotFoundException if no main course is found with the given ID
     */
    @Override
    public MainCourse updateMainCourse(int id, MainCourse updatedCourse) {
        MainCourse existing = getMainCourseById(id);
        existing.setName(updatedCourse.getName());
        existing.setDescription(updatedCourse.getDescription());
        existing.setMainElement1(updatedCourse.getMainElement1());
        existing.setMainElement2(updatedCourse.getMainElement2());
        existing.setCookedVeggies(updatedCourse.getCookedVeggies());
        existing.setStarches(updatedCourse.getStarches());
        existing.setSalads(updatedCourse.getSalads());
        existing.setSauce(updatedCourse.getSauce());
        return mainCourseRepository.save(existing);
    }

    /**
     * Deletes a main course by ID.
     *
     * @param id the ID of the main course to delete
     * @throws ResourceNotFoundException if no main course is found with the given ID
     */
    @Override
    public void deleteMainCourse(int id) {
        MainCourse existing = getMainCourseById(id);
        mainCourseRepository.delete(existing);
    }
}
