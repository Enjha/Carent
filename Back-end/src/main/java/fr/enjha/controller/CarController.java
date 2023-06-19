package fr.enjha.controller;

import fr.enjha.repository.CarRepository;
import fr.enjha.repository.PersonRepository;
import fr.enjha.service.model.Car;
import fr.enjha.service.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarRepository carRepository;
    private final PersonRepository personRepository;

    CarController(CarRepository carRepository, PersonRepository personRepository) {
        this.carRepository = carRepository;
        this.personRepository = personRepository;
    }

    @GetMapping
    List<Car> allCars() {
        return (List<Car>) carRepository.findAll();
    }
    @GetMapping(value = "/{id}")
    Optional<Car> getCarById(@PathVariable int id){
        return carRepository.findById(id);
    }

    @GetMapping("/owner")
    Optional<List<Car>> getCarsByOwnerId(@RequestParam("id") int ownerId){
        Optional<Person> owner = personRepository.findById(ownerId);
        return owner.map(carRepository::findCarsByOwner).orElse(null);
    }

    @GetMapping(value = "/search")
    Optional<List<Car>> getCarsByFilter(@RequestParam("brand") String brand, @RequestParam("model") String model,
                                        @RequestParam("minModelyear") int minModelyear, @RequestParam("maxModelyear") int maxModelyear,
                                        @RequestParam("minPrice") int minPrice, @RequestParam("maxPrice") int maxPrice,
                                        @RequestParam("minKm") int minKm, @RequestParam("maxKm") int maxKm){
        return carRepository.findCarsByFilter(brand,model,minModelyear,maxModelyear,minPrice,maxPrice,minKm,maxKm);
    }
    @PostMapping
    public Car postCar(@RequestBody Car c) {
        carRepository.save(c);
        return c;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePerson(@PathVariable int id) {
        carRepository.deleteById(id);
    }
}
