package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.model.MainCourse;

import java.util.List;

public interface MainCourseService {
    List<MainCourse> getAllMainCourses();
    MainCourse getMainCourseById(int id);
    MainCourse createMainCourse(MainCourse mainCourse);
    MainCourse updateMainCourse(int id, MainCourse mainCourse);
    void deleteMainCourse(int id);
}
