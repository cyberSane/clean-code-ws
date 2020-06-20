package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return new TextStatement(this.name, totalAmount(), totalFrequentRenters(), this.rentals).statement();
    }

    public String htmlStatement() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlHeader() {
        return "<h1>Rental Record for <b>" + getName() + "</b></h1><br/>";
    }

    private String htmlFooter() {
        String result = "Amount owed is " + totalAmount() + "<br/>";
        result += "You earned " + totalFrequentRenters()
                + " frequent renter points";
        return result;
    }

    private String htmlBody() {
        String result = "";
        for (Rental rental : rentals) {
            //show figures for this rental
            result += rental.movie.getMovie().getTitle() + " " + rental.amount() + "<br/>";
        }

        return result;
    }

    private int totalFrequentRenters() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.frequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    private double totalAmount() {
        double totaAmount = 0;
        for (Rental rental : rentals) {
            double amount = rental.amount();
            totaAmount += amount;
        }
        return totaAmount;
    }
}

