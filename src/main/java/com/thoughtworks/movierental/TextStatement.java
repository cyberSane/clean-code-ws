package com.thoughtworks.movierental;

import java.util.List;

public class TextStatement {
    private final String customerName;
    private final double totalAmount;
    private final int totalFrequentRenters;
    private final List<Rental> rentals;

    public TextStatement(String customerName, double totalAmount, int totalFrequentRenters, List<Rental> rentals) {
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.totalFrequentRenters = totalFrequentRenters;
        this.rentals = rentals;
    }

    public String statement() {
        return header() + body() + footer();
    }

    String header() {
        return "Rental Record for " + customerName + "\n";
    }

    String footer() {
        String result = "Amount owed is " + totalAmount + "\n";
        result += "You earned " + totalFrequentRenters
                + " frequent renter points";
        return result;
    }

    String body() {
        String result = "";
        for (Rental rental : rentals) {
            //show figures for this rental
            result += "\t" + rental.movie.getMovie().getTitle() + "\t" + rental.amount() + "\n";
        }

        return result;
    }
}