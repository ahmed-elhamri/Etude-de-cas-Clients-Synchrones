package com.example.car;


import com.example.car.entities.Car;
import com.example.car.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class, args);
    }

    @Bean
    CommandLineRunner loadData(CarRepository carRepository) {
        return args -> {

            carRepository.save(new Car(null, "Toyota", "A 123 45", "Corolla", 1L, null));
            carRepository.save(new Car(null, "Renault", "B 987 65", "Clio", 1L, null));
            carRepository.save(new Car(null, "Peugeot", "C 456 78", "208", 2L, null));
            carRepository.save(new Car(null, "Mercedes", "D 222 11", "C-Class", 3L, null));
            carRepository.save(new Car(null, "BMW", "E 555 22", "320i", 2L, null));

            System.out.println("✔ Fake voiture dataset loaded!");
        };
    }
}
