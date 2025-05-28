package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.model.Drink;
import com.eventsapp.backend.repository.DrinkRepository;
import com.eventsapp.backend.service.impl.DrinkService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository drinkRepository;

    public DrinkServiceImpl(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @Override
    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    @Override
    public Drink getDrinkById(int id) {
        return drinkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Drink not found with ID: " + id));
    }

    @Override
    public Drink createDrink(Drink drink) {
        return drinkRepository.save(drink);
    }

    @Override
    public Drink updateDrink(int id, Drink updatedDrink) {
        Drink existing = getDrinkById(id);
        existing.setName(updatedDrink.getName());
        existing.setDrinkType(updatedDrink.getDrinkType());
        return drinkRepository.save(existing);
    }

    @Override
    public void deleteDrink(int id) {
        if (!drinkRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Drink not found with ID: " + id);
        }
        drinkRepository.deleteById(id);
    }
}
