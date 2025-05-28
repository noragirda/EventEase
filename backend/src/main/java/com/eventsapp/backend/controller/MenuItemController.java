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

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class MenuItemController {

    private final ApetizerRepository apetizerRepository;
    private final SoupRepository soupRepository;
    private final MainCourseRepository mainCourseRepository;

    @GetMapping("/apetizers")
    public List<Apetizer> getAllApetizers() {
        return apetizerRepository.findAll();
    }

    @GetMapping("/soups")
    public List<Soup> getAllSoups() {
        return soupRepository.findAll();
    }

    @GetMapping("/main-courses")
    public List<MainCourse> getAllMainCourses() {
        return mainCourseRepository.findAll();
    }
}
