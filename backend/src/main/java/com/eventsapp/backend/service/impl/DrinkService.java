package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.model.Drink;

import java.util.List;

public interface DrinkService {
    List<Drink> getAllDrinks();
    Drink getDrinkById(int id);
    Drink createDrink(Drink drink);
    Drink updateDrink(int id, Drink drink);
    void deleteDrink(int id);
}
