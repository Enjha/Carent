package fr.enjha.controller;

import fr.enjha.repository.CarRepository;
import fr.enjha.service.model.Car;
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
    @GetMapping(value = "/cars/search")
    Optional<List<Car>> getCarsByFilter(@RequestParam("brand") String brand, @RequestParam("model") String model,
                                        @RequestParam("minModelyear") int minModelyear, @RequestParam("maxModelyear") int maxModelyear,
                                        @RequestParam("minPrice") int minPrice, @RequestParam("maxPrice") int maxPrice){
        return repository.findCarsByFilter(brand,model,minModelyear,maxModelyear,minPrice,maxPrice);
    }
    @DeleteMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePerson(@PathVariable int id) {
        repository.deleteById(id);
    }
}
