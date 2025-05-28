package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.model.Apetizer;
import com.eventsapp.backend.repository.ApetizerRepository;
import com.eventsapp.backend.service.impl.ApetizerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApetizerServiceImpl implements ApetizerService {

    private final ApetizerRepository apetizerRepository;

    public ApetizerServiceImpl(ApetizerRepository apetizerRepository) {
        this.apetizerRepository = apetizerRepository;
    }

    @Override
    public List<Apetizer> getAllApetizers() {
        return apetizerRepository.findAll();
    }

    @Override
    public Apetizer getApetizerById(int id) {
        return apetizerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Apetizer not found with ID: " + id));
    }

    @Override
    public Apetizer createApetizer(Apetizer apetizer) {
        return apetizerRepository.save(apetizer);
    }

    @Override
    public Apetizer updateApetizer(int id, Apetizer updated) {
        Apetizer existing = getApetizerById(id);
        existing.setName(updated.getName());
        existing.setMaxNumberOfPieces(updated.getMaxNumberOfPieces());
        return apetizerRepository.save(existing);
    }

    @Override
    public void deleteApetizer(int id) {
        if (!apetizerRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Apetizer not found with ID: " + id);
        }
        apetizerRepository.deleteById(id);
    }
}
