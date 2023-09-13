package com.example.immutableexample.controller;

import com.example.immutableexample.model.Car;
import com.example.immutableexample.model.CarIdentifier;
import com.example.immutableexample.service.CarRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/cars")
public class Controller {

    CarRepo carRepo;

    public Controller(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @GetMapping
    public ResponseEntity<String> getCars(@RequestParam(name = "VIN", required = false) String VIN, @RequestParam(name = "number", required = false) String number) {

        Set<Car> foundCars = new HashSet<>();

        if (number!=null) foundCars.addAll(carRepo.findByNumber(number));
        if (VIN!=null) foundCars.addAll(carRepo.findByVIN(VIN));


        return new ResponseEntity<>(foundCars.toString(), foundCars.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

}
