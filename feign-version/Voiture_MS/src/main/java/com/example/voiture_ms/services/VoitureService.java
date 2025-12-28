package com.example.voiture_ms.services;

import com.example.voiture_ms.entities.Voiture;
import com.example.voiture_ms.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoitureService {

    @Autowired
    VoitureRepository voitureRepository;

    public Voiture enregistrerVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }
}
