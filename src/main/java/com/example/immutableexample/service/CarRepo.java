package com.example.immutableexample.service;

import com.example.immutableexample.model.CarIdentifier;
import com.example.immutableexample.model.Colour;
import com.example.immutableexample.model.Car;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class CarRepo {

    private List<Car> cars = new ArrayList<>();

    {
        addCar(new Car("a007", "111", Colour.GREEN));
        addCar(new Car("a008", "112", Colour.BLUE));
        addCar(new Car("a009", "113", Colour.BLACK));
    }

    public void addCar(Car car) {

        this.cars.add(car);

    }

    public void clearCars() {
        this.cars.clear();
    }

    public List<Car> findByVIN(String VIN){

        List<Car> foundCars = new ArrayList<>();

        for (Car car:cars
             ) {
            if (car.getVIN().equals(VIN)) foundCars.add(car);
        }

        return foundCars;
    }

    public List<Car> findByNumber(String number){

        List<Car> foundCars = new ArrayList<>();

        for (Car car:cars
        ) {
            if (car.getNumber().equals(number)) foundCars.add(car);
        }

        return foundCars;
    }

//    public List<Car> findCar(CarIdentifier car) {
//
//        return cars.stream()
//                .filter((t) -> car.VIN() == null || t.getVIN().equals(car.VIN()))
//                .filter((t) -> car.number() == null || t.getNumber().equals(car.number()))
//                .collect(Collectors.toCollection(ArrayList::new));
//    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
