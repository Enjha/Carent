package fr.enjha.controller;

import fr.enjha.repository.CarRepository;
import fr.enjha.service.model.Car;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarRepository repository;

    CarController(CarRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<Car> allCars() {
        return (List<Car>) repository.findAll();
    }
    @GetMapping(value = "/{id}")
    Optional<Car> getCarById(@PathVariable int id){
        return repository.findById(id);
    }
    @GetMapping(value = "/search")
    Optional<List<Car>> getCarsByFilter(@RequestParam("brand") String brand, @RequestParam("model") String model,
                                        @RequestParam("minModelyear") int minModelyear, @RequestParam("maxModelyear") int maxModelyear,
                                        @RequestParam("minPrice") int minPrice, @RequestParam("maxPrice") int maxPrice,
                                        @RequestParam("minKm") int minKm, @RequestParam("maxKm") int maxKm){
        return repository.findCarsByFilter(brand,model,minModelyear,maxModelyear,minPrice,maxPrice,minKm,maxKm);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePerson(@PathVariable int id) {
        repository.deleteById(id);
    }
}
