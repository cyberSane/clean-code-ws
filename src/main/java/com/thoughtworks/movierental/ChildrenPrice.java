package com.thoughtworks.movierental;

public class ChildrenPrice implements Price {
    public double amount(int daysRented) {
        double amount = 0;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        amount += 1.5;
        return amount;
    }
}
