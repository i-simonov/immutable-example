package com.example.immutableexample.controller;

import com.example.immutableexample.model.Car;
import com.example.immutableexample.service.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/v1/cars")
public class Controller {

    CarRepository carRepository;

    public Controller(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public ResponseEntity<Set<Car>> getCars(@RequestParam(name = "VIN", required = false) String VIN, @RequestParam(name = "number", required = false) String number) {

        Set<Car> foundCars = new HashSet<>();

        if (number != null){
            foundCars.addAll(carRepository.findByNumber(number));
        }
        if (VIN != null){
            foundCars.addAll(carRepository.findByVin(VIN));
        }


        return new ResponseEntity<>(foundCars, foundCars.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

}
