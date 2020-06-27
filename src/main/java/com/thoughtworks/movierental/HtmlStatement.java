package com.thoughtworks.movierental;

import java.util.List;

public class HtmlStatement {
    private final String name;
    private final Rentals rentals;

    public HtmlStatement(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String createHTMLStatement() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    String htmlHeader() {
        String header = "";
        header = "<h1>Rental Record for <b>" + name + "</b></h1><br/>";
        return header;
    }

    String htmlBody() {
        String body = "";
        for (Rental rental : rentals.rentals) {
            body += rental.getMovie().getTitle() + " " + rental.amount() + "<br/>";
        }
        return body;
    }

    String htmlFooter() {
        String footer = "";
        footer += "Amount owed is <b>" + rentals.totalAmount() + "<b><br/>";
        footer += "You earned <b>" + rentals.totalFrequentRenters() + "</b> frequent renter points";
        return footer;
    }
}