package com.eventsapp.backend.repository;

import com.eventsapp.backend.model.MainCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface MainCourseRepository extends JpaRepository<MainCourse, Integer> {}