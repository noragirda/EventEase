package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.model.Apetizer;
import com.eventsapp.backend.repository.ApetizerRepository;
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
class ApetizerServiceImplTest {

    @Mock
    private ApetizerRepository apetizerRepository;

    @InjectMocks
    private ApetizerServiceImpl apetizerService;

    private Apetizer sample;

    @BeforeEach
    void setUp() {
        sample = new Apetizer();
        sample.setId(1);
        sample.setName("Bruschetta");
        sample.setMaxNumberOfPieces(20);
    }

    @Test
    void testGetAllApetizers() {
        List<Apetizer> mockList = Arrays.asList(sample);
        when(apetizerRepository.findAll()).thenReturn(mockList);

        List<Apetizer> result = apetizerService.getAllApetizers();

        assertEquals(1, result.size());
        assertEquals("Bruschetta", result.get(0).getName());
        verify(apetizerRepository).findAll();
    }

    @Test
    void testGetApetizerById_Found() {
        when(apetizerRepository.findById(1)).thenReturn(Optional.of(sample));

        Apetizer result = apetizerService.getApetizerById(1);

        assertEquals("Bruschetta", result.getName());
        verify(apetizerRepository).findById(1);
    }

    @Test
    void testGetApetizerById_NotFound() {
        when(apetizerRepository.findById(2)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> apetizerService.getApetizerById(2));
    }

    @Test
    void testCreateApetizer() {
        when(apetizerRepository.save(sample)).thenReturn(sample);

        Apetizer result = apetizerService.createApetizer(sample);

        assertEquals("Bruschetta", result.getName());
        verify(apetizerRepository).save(sample);
    }

    @Test
    void testUpdateApetizer_Success() {
        Apetizer updated = new Apetizer(1, "Stuffed Mushrooms", 15);
        when(apetizerRepository.findById(1)).thenReturn(Optional.of(sample));
        when(apetizerRepository.save(any())).thenReturn(updated);

        Apetizer result = apetizerService.updateApetizer(1, updated);

        assertEquals("Stuffed Mushrooms", result.getName());
        assertEquals(15, result.getMaxNumberOfPieces());
        verify(apetizerRepository).save(any());
    }

    @Test
    void testDeleteApetizer_Success() {
        when(apetizerRepository.existsById(1)).thenReturn(true);

        apetizerService.deleteApetizer(1);

        verify(apetizerRepository).deleteById(1);
    }

    @Test
    void testDeleteApetizer_NotFound() {
        when(apetizerRepository.existsById(2)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> apetizerService.deleteApetizer(2));
    }
}
