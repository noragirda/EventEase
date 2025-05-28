package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.model.Soup;
import com.eventsapp.backend.repository.SoupRepository;
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
class SoupServiceImplTest {

    @Mock
    private SoupRepository soupRepository;

    @InjectMocks
    private SoupServiceImpl soupService;

    private Soup sampleSoup;

    @BeforeEach
    void setUp() {
        sampleSoup = new Soup();
        sampleSoup.setId(1);
        sampleSoup.setName("Chicken Soup");
    }

    @Test
    void testGetAllSoups() {
        when(soupRepository.findAll()).thenReturn(Arrays.asList(sampleSoup));

        List<Soup> result = soupService.getAllSoups();

        assertEquals(1, result.size());
        assertEquals("Chicken Soup", result.get(0).getName());
        verify(soupRepository).findAll();
    }

    @Test
    void testGetSoupById_Found() {
        when(soupRepository.findById(1)).thenReturn(Optional.of(sampleSoup));

        Soup result = soupService.getSoupById(1);

        assertNotNull(result);
        assertEquals("Chicken Soup", result.getName());
        verify(soupRepository).findById(1);
    }

    @Test
    void testGetSoupById_NotFound() {
        when(soupRepository.findById(2)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> soupService.getSoupById(2));
    }

    @Test
    void testCreateSoup() {
        when(soupRepository.save(sampleSoup)).thenReturn(sampleSoup);

        Soup result = soupService.createSoup(sampleSoup);

        assertEquals("Chicken Soup", result.getName());
        verify(soupRepository).save(sampleSoup);
    }

    @Test
    void testUpdateSoup_Success() {
        Soup updated = new Soup();
        updated.setName("Tomato Soup");

        when(soupRepository.findById(1)).thenReturn(Optional.of(sampleSoup));
        when(soupRepository.save(any())).thenReturn(updated);

        Soup result = soupService.updateSoup(1, updated);

        assertEquals("Tomato Soup", result.getName());
        verify(soupRepository).save(any());
    }

    @Test
    void testDeleteSoup_Success() {
        when(soupRepository.existsById(1)).thenReturn(true);

        soupService.deleteSoup(1);

        verify(soupRepository).deleteById(1);
    }

    @Test
    void testDeleteSoup_NotFound() {
        when(soupRepository.existsById(999)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> soupService.deleteSoup(999));
    }
}
