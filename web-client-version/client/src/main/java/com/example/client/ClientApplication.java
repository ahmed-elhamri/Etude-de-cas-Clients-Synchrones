package com.example.client;

import com.example.client.entities.Client;
import com.example.client.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(ClientRepository clientRepository) {
        return args -> {

            // Clear DB (optional for development)
            clientRepository.deleteAll();

            clientRepository.save(new Client(null, "Ahmed", 25f));
            clientRepository.save(new Client(null, "Fatima", 30f));
            clientRepository.save(new Client(null, "Youssef", 22f));
            clientRepository.save(new Client(null, "Salma", 28f));
            clientRepository.save(new Client(null, "Omar", 35f));

            System.out.println("✔ Fake dataset loaded into H2 database!");
        };
    }
}
