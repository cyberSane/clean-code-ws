package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Rentals {
    List<Rental> rentals = new ArrayList<Rental>();

    int totalFrequentRenters() {
        int frequentRenterPoints = 0;
        for (Rental rental : this.rentals) {
            frequentRenterPoints += rental.frequentRenter();
        }
        return frequentRenterPoints;
    }

    double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : this.rentals) {
            totalAmount += rental.amount();
        }
        return totalAmount;
    }
}