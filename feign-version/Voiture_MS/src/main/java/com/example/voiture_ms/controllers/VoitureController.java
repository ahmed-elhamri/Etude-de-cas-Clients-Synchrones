package com.example.voiture_ms.controllers;

import com.example.voiture_ms.entities.Client;
import com.example.voiture_ms.entities.Voiture;
import com.example.voiture_ms.repositories.VoitureRepository;
import com.example.voiture_ms.services.ClientService;
import com.example.voiture_ms.services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoitureController {

    @Autowired
    VoitureRepository voitureRepository;

    @Autowired
    VoitureService voitureService;

    @Autowired
    ClientService clientService;


    @GetMapping(value = "/voitures", produces = {"application/json"})
    public ResponseEntity<Object> findAll() {
        List<Voiture> voitures = voitureRepository.findAll();
        for(Voiture voiture : voitures){
            voiture.setClient(clientService.clientById(voiture.getClientId()));
        }
        return ResponseEntity.ok(voitures);
    }


    @GetMapping("/voitures/{id}")
    public ResponseEntity<Voiture> findById(@PathVariable Long id) {
        try {
            Voiture voiture = voitureRepository.findById(id)
                    .orElseThrow(() -> new Exception("Voiture Introuvable"));

            voiture.setClient(clientService.clientById(voiture.getClientId()));

            return ResponseEntity.ok(voiture);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/voitures/client/{id}")
    public ResponseEntity<List<Voiture>> findByClient(@PathVariable Long id) {
        return ResponseEntity.ok(voitureRepository.findByClientId(id));
    }


    @PostMapping("/voitures/{clientId}")
    public ResponseEntity<Object> save(@PathVariable Long clientId, @RequestBody Voiture voiture) {
        Client client = clientService.clientById(clientId);

        voiture.setClientId(clientId);
        voiture.setClient(client);

        return ResponseEntity.ok(voitureService.enregistrerVoiture(voiture));
    }
}
