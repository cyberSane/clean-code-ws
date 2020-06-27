package com.thoughtworks.movierental;

import java.util.List;

public class TextStatement {
    private final String name;
    private Rentals rentals;

    public TextStatement(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String createStatement() {
        return textHeader() + textBody() + textFooter();
    }

    String textHeader() {
        String header = "";
        header = "Rental Record for " + name + "\n";
        return header;
    }

    String textBody() {
        String body = "";
        for (Rental rental : rentals.rentals) {
            body += "\t" + rental.getMovie().getTitle() + "\t" + rental.amount() + "\n";
        }
        return body;
    }

    String textFooter() {
        String footer = "";
        footer += "Amount owed is " + rentals.totalAmount() + "\n";
        footer += "You earned " + rentals.totalFrequentRenters() + " frequent renter points";
        return footer;
    }
}