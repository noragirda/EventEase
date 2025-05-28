package com.eventsapp.backend.service.impl;


import com.eventsapp.backend.model.Soup;
import com.eventsapp.backend.repository.SoupRepository;
import com.eventsapp.backend.service.impl.SoupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoupServiceImpl implements SoupService {

    private final SoupRepository soupRepository;

    public SoupServiceImpl(SoupRepository soupRepository) {
        this.soupRepository = soupRepository;
    }

    @Override
    public List<Soup> getAllSoups() {
        return soupRepository.findAll();
    }

    @Override
    public Soup getSoupById(int id) {
        return soupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Soup not found with ID: " + id));
    }

    @Override
    public Soup createSoup(Soup soup) {
        return soupRepository.save(soup);
    }

    @Override
    public Soup updateSoup(int id, Soup updatedSoup) {
        Soup existing = getSoupById(id);
        existing.setName(updatedSoup.getName());
        return soupRepository.save(existing);
    }

    @Override
    public void deleteSoup(int id) {
        if (!soupRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Soup not found with ID: " + id);
        }
        soupRepository.deleteById(id);
    }
}
