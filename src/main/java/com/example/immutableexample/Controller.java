package com.example.immutableexample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/cars")
public class Controller {

    CarRepoService carRepo;

    public Controller(CarRepoService carRepo) {
        this.carRepo = carRepo;
    }

    @GetMapping
    public ResponseEntity<String> getCars (@RequestParam(name="VIN", required=false) String VIN, @RequestParam(name="number", required=false) String number) {

        CarIdentifier carToFind = new CarIdentifier(number,VIN);

        ArrayList<Car> findCars = carRepo.findCar(carToFind);

        return new ResponseEntity<>(findCars.toString(),findCars.isEmpty()?HttpStatus.NOT_FOUND:HttpStatus.OK);
    }

}
