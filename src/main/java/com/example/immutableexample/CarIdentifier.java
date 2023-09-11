package com.example.immutableexample;

import java.util.Objects;

public final class CarIdentifier {

    private final String number;
    private final String VIN;

    public CarIdentifier(String number, String VIN) {
        this.number = number;
        this.VIN = VIN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarIdentifier that = (CarIdentifier) o;
        return Objects.equals(number, that.number) && Objects.equals(VIN, that.VIN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, VIN);
    }

    public String getNumber() {
        return number;
    }

    public String getVIN() {
        return VIN;
    }
}
