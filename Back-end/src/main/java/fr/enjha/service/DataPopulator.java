package fr.enjha.service;

import com.github.javafaker.Faker;
import fr.enjha.repository.CarRepository;
import fr.enjha.repository.PersonRepository;
import fr.enjha.service.model.Car;
import fr.enjha.service.model.Person;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DataPopulator {

    private final PersonRepository personRepository;
    private final CarRepository carRepository;

    public DataPopulator(PersonRepository personRepository, CarRepository carRepository) {
        this.personRepository = personRepository;
        this.carRepository = carRepository;
    }

    public void populateData() {
        Faker faker = new Faker();

        String[] brandName = { "Audi", "BMW", "Honda", "Mercedes", "Toyota"};
        Random random = new Random();

        // Créer des instances de Person
        Person person1 = new Person();
        person1.setFirstName(faker.name().firstName());
        person1.setLastName(faker.name().lastName());
        person1.setBirthDate(faker.date().birthday());
        person1.setPhone(faker.phoneNumber().phoneNumber());

        Person person2 = new Person();
        person2.setFirstName(faker.name().firstName());
        person2.setLastName(faker.name().lastName());
        person2.setBirthDate(faker.date().birthday());
        person2.setPhone(faker.phoneNumber().phoneNumber());

        // Enregistrer les personnes dans la base de données
        personRepository.save(person1);
        personRepository.save(person2);

        Person person;
        for(int i=0;i<=20;i++){

            if(i<10)
                person = person1;
            else
                person = person2;
            Car car = new Car();
            car.setOwner(person);
            car.setBrand(brandName[random.nextInt(brandName.length - 1)]);
            car.setModel("model " + random.nextInt(7));
            car.setModelYear(faker.date().birthday().getYear());
            car.setNumberOfKilometer(faker.number().numberBetween(20000,300000));
            car.setPrice(faker.number().numberBetween(500, 100000));

            carRepository.save(car);
        }
    }

    @PostConstruct
    public void init() {
        populateData();
    }
}

