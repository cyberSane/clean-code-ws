package com.thoughtworks.movierental;

public class DefaultPrice implements Price {
    @Override
    public double amount(int daysRented) {
        return 1;
    }
}
