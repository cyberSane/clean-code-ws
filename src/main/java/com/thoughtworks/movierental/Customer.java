package com.thoughtworks.movierental;

public class Customer {
    private final Rentals rentals = new Rentals();
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return new TextStatement(getName(), this.rentals).createStatement();
    }

    public String htmlStatement() {
        return new HtmlStatement(getName(), this.rentals).createHTMLStatement();
    }

    private int totalFrequentRenters() {
        return rentals.totalFrequentRenters();
    }

    private double totalAmount() {
        return rentals.totalAmount();
    }

}