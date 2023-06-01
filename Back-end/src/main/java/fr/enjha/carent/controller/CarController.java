package fr.yann.carent.controller;

import fr.yann.carent.repository.CarRepository;
import fr.yann.carent.service.model.Car;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    private final CarRepository repository;

    CarController(CarRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cars")
    List<Car> allCars() {
        return (List<Car>) repository.findAll();
    }

    @GetMapping(value = "/cars/{id}")
    Optional<Car> getCarById(@PathVariable int id){
        return repository.findById(id);
    }

    @DeleteMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePerson(@PathVariable int id) {
        repository.deleteById(id);
    }

}
