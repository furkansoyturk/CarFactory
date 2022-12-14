package com.example.car.repository;

import com.example.car.model.CarFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository extends RuntimeException {

    public List<CarFactory> findAll() {
        List<CarFactory> cars = produceFakeDataAsADataSource();
        return cars;
    }

    public List<CarFactory> produceFakeDataAsADataSource() {
        List<CarFactory> cars = new ArrayList<>();
        CarFactory typeSedan = new CarFactory();
        CarFactory typeCabrio = new CarFactory();
        CarFactory typeHatchback = new CarFactory();

        typeSedan.setType("Sedan");
        typeSedan.setColor("Black");
        typeSedan.setModel("A431");

        typeCabrio.setType("Cabrio");
        typeCabrio.setColor("Yellow");
        typeCabrio.setModel("S432");

        typeHatchback.setType("Hatchback");
        typeHatchback.setColor("Blue");
        typeHatchback.setModel("V12");

        cars.add(typeSedan);
        cars.add(typeCabrio);
        cars.add(typeHatchback);

        return cars;
    }
}
