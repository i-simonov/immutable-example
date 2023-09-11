package com.example.immutableexample;

import java.util.Objects;

public class Car{

    private final String number;
    private final String VIN;
    private Colour colour;


    public Car(String number, String VIN, Colour colour) {
        this.number = number;
        this.VIN = VIN;
        this.colour = colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(number, car.number) && Objects.equals(VIN, car.VIN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, VIN);
    }

    @Override
    public String toString() {
        return "{" +
                "number='" + number + '\'' +
                ", VIN='" + VIN + '\'' +
                ", colour=" + colour +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public String getVIN() {
        return VIN;
    }

    public Colour getColour() {
        return colour;
    }

}
