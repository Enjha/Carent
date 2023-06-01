CREATE DATABASE car;
USE car;

CREATE TABLE cars(
    id INT NOT NULL AUTO_INCREMENT,
    brand varchar(100) NOT NULL,
    model varchar(100) NOT NULL,
    model_year INT(4) NOT NULL,
    number_of_kilometer INT(6) NOT NULL,
    price INT(8) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO cars(brand, model, model_year, number_of_kilometer, price) VALUES ("Toyota", "Yaris", "2010", "100000", "3600"), ("Audi", "A4", "2020", "120000", "10400"), ("Mercedes", "Classe A", "2022", "53050", "12430");