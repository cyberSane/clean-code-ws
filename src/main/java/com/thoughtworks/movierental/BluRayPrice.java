package com.thoughtworks.movierental;

public class BluRayPrice implements Price {
    public double amount(int daysRented) {
        return daysRented * 4;
    }
}
