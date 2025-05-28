package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.exception.ResourceNotFoundException;
import com.eventsapp.backend.model.MainCourse;
import com.eventsapp.backend.repository.MainCourseRepository;
import com.eventsapp.backend.service.impl.MainCourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainCourseServiceImpl implements MainCourseService {

    private final MainCourseRepository mainCourseRepository;

    public MainCourseServiceImpl(MainCourseRepository mainCourseRepository) {
        this.mainCourseRepository = mainCourseRepository;
    }

    @Override
    public List<MainCourse> getAllMainCourses() {
        return mainCourseRepository.findAll();
    }

    @Override
    public MainCourse getMainCourseById(int id) {
        return mainCourseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Main course not found with id: " + id));
    }

    @Override
    public MainCourse createMainCourse(MainCourse mainCourse) {
        return mainCourseRepository.save(mainCourse);
    }

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

    @Override
    public void deleteMainCourse(int id) {
        MainCourse existing = getMainCourseById(id);
        mainCourseRepository.delete(existing);
    }
}
