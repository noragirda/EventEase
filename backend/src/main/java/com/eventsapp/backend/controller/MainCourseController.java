package com.eventsapp.backend.controller;

import com.eventsapp.backend.model.MainCourse;
import com.eventsapp.backend.service.impl.MainCourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/main-courses")
@CrossOrigin(origins = "http://localhost:3000")
public class MainCourseController {

    private final MainCourseService mainCourseService;

    public MainCourseController(MainCourseService mainCourseService) {
        this.mainCourseService = mainCourseService;
    }

    @GetMapping
    public ResponseEntity<List<MainCourse>> getAllMainCourses() {
        return ResponseEntity.ok(mainCourseService.getAllMainCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MainCourse> getMainCourseById(@PathVariable int id) {
        return ResponseEntity.ok(mainCourseService.getMainCourseById(id));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<MainCourse> createMainCourse(@RequestBody MainCourse mainCourse) {
        return ResponseEntity.ok(mainCourseService.createMainCourse(mainCourse));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<MainCourse> updateMainCourse(@PathVariable int id, @RequestBody MainCourse mainCourse) {
        return ResponseEntity.ok(mainCourseService.updateMainCourse(id, mainCourse));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMainCourse(@PathVariable int id) {
        mainCourseService.deleteMainCourse(id);
        return ResponseEntity.noContent().build();
    }
}
