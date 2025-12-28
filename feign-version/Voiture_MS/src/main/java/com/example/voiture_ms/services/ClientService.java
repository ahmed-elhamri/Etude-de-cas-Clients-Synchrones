package com.example.voiture_ms.services;

import com.example.voiture_ms.entities.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SERVICE-CLIENT")
public interface ClientService {

    @GetMapping("/clients/{id}")
    Client clientById(@PathVariable Long id);
}
