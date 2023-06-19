package fr.enjha.controller;

import fr.enjha.repository.PersonRepository;
import fr.enjha.service.model.Car;
import fr.enjha.service.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonRepository repository;

    PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<Person> allCars() {
        return (List<Person>) repository.findAll();
    }
    @GetMapping(value = "/{id}")
    Optional<Person> getCarById(@PathVariable int id){
        return repository.findById(id);
    }

    @PostMapping
    public Person postCar(@RequestBody Person p) {
        repository.save(p);
        return p;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePerson(@PathVariable int id) {
        repository.deleteById(id);
    }
}
