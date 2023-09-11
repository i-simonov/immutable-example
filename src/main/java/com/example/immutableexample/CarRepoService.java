package com.example.immutableexample;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static java.util.Arrays.copyOf;

@Component
@Service
public class CarRepoService {

    private ArrayList<Car> cars = new ArrayList<>();

    {
        addCar(new Car("a007","111",Colour.GREEN));
        addCar(new Car("a008","112",Colour.BLUE));
        addCar(new Car("a009","113",Colour.BLACK));
    }

    public void addCar(Car car){

        this.cars.add(car);

    }

    public void clearCars(){
        this.cars.clear();
    }
    public ArrayList<Car> findCar(CarIdentifier car){

        return cars.stream()
                .filter((t)-> car.getVIN()==null || t.getVIN().equals(car.getVIN()))
                .filter((t)-> car.getNumber()==null || t.getNumber().equals(car.getNumber()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
