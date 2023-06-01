package fr.yann.carent.repository;

import fr.yann.carent.service.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
}
