package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.exception.ResourceNotFoundException;
import com.eventsapp.backend.model.MainCourse;
import com.eventsapp.backend.repository.MainCourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MainCourseServiceImplTest {

    @Mock
    private MainCourseRepository mainCourseRepository;

    @InjectMocks
    private MainCourseServiceImpl mainCourseService;

    private MainCourse sample;

    @BeforeEach
    void setUp() {
        sample = new MainCourse();
        sample.setId(1);
        sample.setName("Chicken Parm");
        sample.setDescription("Breaded chicken with marinara and cheese");
        sample.setMainElement1("Chicken");
        sample.setMainElement2("Cheese");
        sample.setCookedVeggies("Broccoli");
        sample.setStarches("Mashed Potatoes");
        sample.setSalads("Caesar");
        sample.setSauce("Marinara");
    }

    @Test
    void testGetAllMainCourses() {
        when(mainCourseRepository.findAll()).thenReturn(Arrays.asList(sample));

        List<MainCourse> result = mainCourseService.getAllMainCourses();

        assertEquals(1, result.size());
        assertEquals("Chicken Parm", result.get(0).getName());
        verify(mainCourseRepository).findAll();
    }

    @Test
    void testGetMainCourseById_Found() {
        when(mainCourseRepository.findById(1)).thenReturn(Optional.of(sample));

        MainCourse result = mainCourseService.getMainCourseById(1);

        assertNotNull(result);
        assertEquals("Chicken Parm", result.getName());
        verify(mainCourseRepository).findById(1);
    }

    @Test
    void testGetMainCourseById_NotFound() {
        when(mainCourseRepository.findById(2)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> mainCourseService.getMainCourseById(2));
    }

    @Test
    void testCreateMainCourse() {
        when(mainCourseRepository.save(sample)).thenReturn(sample);

        MainCourse result = mainCourseService.createMainCourse(sample);

        assertEquals("Chicken Parm", result.getName());
        verify(mainCourseRepository).save(sample);
    }

    @Test
    void testUpdateMainCourse_Success() {
        MainCourse updated = new MainCourse();
        updated.setName("Beef Wellington");
        updated.setDescription("Beef in pastry");
        updated.setMainElement1("Beef");
        updated.setMainElement2("Pastry");
        updated.setCookedVeggies("Asparagus");
        updated.setStarches("Potatoes");
        updated.setSalads("Rocket");
        updated.setSauce("Red wine");

        when(mainCourseRepository.findById(1)).thenReturn(Optional.of(sample));
        when(mainCourseRepository.save(any(MainCourse.class))).thenReturn(updated);

        MainCourse result = mainCourseService.updateMainCourse(1, updated);

        assertEquals("Beef Wellington", result.getName());
        assertEquals("Asparagus", result.getCookedVeggies());
        verify(mainCourseRepository).save(any(MainCourse.class));
    }

    @Test
    void testDeleteMainCourse_Success() {
        when(mainCourseRepository.findById(1)).thenReturn(Optional.of(sample));

        mainCourseService.deleteMainCourse(1);

        verify(mainCourseRepository).delete(sample);
    }

    @Test
    void testDeleteMainCourse_NotFound() {
        when(mainCourseRepository.findById(999)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> mainCourseService.deleteMainCourse(999));
    }
}
