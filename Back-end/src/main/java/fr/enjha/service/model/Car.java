package fr.enjha.service.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cars")
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    private int modelYear;
    private int numberOfKilometer;
    private int price;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int year) {
        this.modelYear = year;
    }

    public int getNumberOfKilometer() {
        return numberOfKilometer;
    }

    public void setNumberOfKilometer(int numberOfKilometer) {
        this.numberOfKilometer = numberOfKilometer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
