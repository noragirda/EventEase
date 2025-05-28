package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.model.Drink;
import com.eventsapp.backend.model.enums.DrinkType;
import com.eventsapp.backend.repository.DrinkRepository;
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
class DrinkServiceImplTest {

    @Mock
    private DrinkRepository drinkRepository;

    @InjectMocks
    private DrinkServiceImpl drinkService;

    private Drink sampleDrink;

    @BeforeEach
    void setUp() {
        sampleDrink = new Drink();
        sampleDrink.setId(1);
        sampleDrink.setName("Cola");
        sampleDrink.setDrinkType(DrinkType.ALCH);
    }

    @Test
    void testGetAllDrinks() {
        when(drinkRepository.findAll()).thenReturn(Arrays.asList(sampleDrink));

        List<Drink> result = drinkService.getAllDrinks();

        assertEquals(1, result.size());
        assertEquals("Cola", result.get(0).getName());
        verify(drinkRepository).findAll();
    }

    @Test
    void testGetDrinkById_Found() {
        when(drinkRepository.findById(1)).thenReturn(Optional.of(sampleDrink));

        Drink result = drinkService.getDrinkById(1);

        assertEquals("Cola", result.getName());
        verify(drinkRepository).findById(1);
    }

    @Test
    void testGetDrinkById_NotFound() {
        when(drinkRepository.findById(2)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> drinkService.getDrinkById(2));
    }

    @Test
    void testCreateDrink() {
        when(drinkRepository.save(sampleDrink)).thenReturn(sampleDrink);

        Drink result = drinkService.createDrink(sampleDrink);

        assertEquals("Cola", result.getName());
        verify(drinkRepository).save(sampleDrink);
    }

    @Test
    void testUpdateDrink_Success() {
        Drink updated = new Drink();
        updated.setName("Pepsi");
        updated.setDrinkType(DrinkType.ALCH);

        when(drinkRepository.findById(1)).thenReturn(Optional.of(sampleDrink));
        when(drinkRepository.save(any())).thenReturn(updated);

        Drink result = drinkService.updateDrink(1, updated);

        assertEquals("Pepsi", result.getName());
        verify(drinkRepository).save(any());
    }

    @Test
    void testDeleteDrink_Success() {
        when(drinkRepository.existsById(1)).thenReturn(true);

        drinkService.deleteDrink(1);

        verify(drinkRepository).deleteById(1);
    }

    @Test
    void testDeleteDrink_NotFound() {
        when(drinkRepository.existsById(999)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> drinkService.deleteDrink(999));
    }
}
