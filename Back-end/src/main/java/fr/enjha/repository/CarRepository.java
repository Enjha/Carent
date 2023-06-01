package fr.enjha.repository;

import fr.enjha.service.model.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
    Optional<List<Car>> findCarsByBrand(String brand);
    @Query("SELECT c FROM Car c " +
            "WHERE c.brand LIKE %:brand%" +
            "AND c.model LIKE %:model%" +
            "AND (c.modelYear BETWEEN :minModelYear AND :maxModelYear)" +
            "AND (c.price BETWEEN :minPrice AND :maxPrice)")
    Optional<List<Car>> findCarsByFilter(@Param("brand") String brand, @Param("model") String model, @Param("minModelYear") int minModelYear, @Param("maxModelYear") int MaxModelYear, @Param("minPrice") int minPrice, @Param("maxPrice") int maxPrice);
}
