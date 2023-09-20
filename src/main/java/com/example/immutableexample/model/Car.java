package com.example.immutableexample.model;

import java.util.Objects;

public class Car {

    private final String number;
    private final String Vin;
    private Colour colour;


    public Car(String number, String Vin, Colour colour) {
        this.number = number;
        this.Vin = Vin;
        this.colour = colour;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        Car car = (Car) o;

        return Objects.equals(number, car.number) && Objects.equals(Vin, car.Vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, Vin);
    }

    @Override
    public String toString() {
        return "{number='%s', VIN='%s', colour= '%s'}".formatted(number, Vin, colour.toString());
    }

    public String getNumber() {
        return number;
    }

    public String getVin() {
        return Vin;
    }

    public Colour getColour() {
        return colour;
    }

}
