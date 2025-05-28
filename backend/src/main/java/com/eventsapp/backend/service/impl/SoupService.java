package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.model.Soup;

import java.util.List;

public interface SoupService {
    List<Soup> getAllSoups();
    Soup getSoupById(int id);
    Soup createSoup(Soup soup);
    Soup updateSoup(int id, Soup soup);
    void deleteSoup(int id);
}
