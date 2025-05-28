package com.eventsapp.backend.service.impl;


import com.eventsapp.backend.model.Apetizer;

import java.util.List;

public interface ApetizerService {
    List<Apetizer> getAllApetizers();
    Apetizer getApetizerById(int id);
    Apetizer createApetizer(Apetizer apetizer);
    Apetizer updateApetizer(int id, Apetizer apetizer);
    void deleteApetizer(int id);
}

