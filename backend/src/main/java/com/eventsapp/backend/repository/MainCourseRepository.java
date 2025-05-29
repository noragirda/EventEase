package com.eventsapp.backend.repository;

import com.eventsapp.backend.model.MainCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link MainCourse} entities.
 * Provides CRUD operations and query methods for main course items.
 */
@Repository
public interface MainCourseRepository extends JpaRepository<MainCourse, Integer> {
}
