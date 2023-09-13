package com.example.immutableexample.model;

import java.util.Objects;

public record CarIdentifier(String number, String VIN) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarIdentifier that = (CarIdentifier) o;
        return Objects.equals(number, that.number) && Objects.equals(VIN, that.VIN);
    }

}
