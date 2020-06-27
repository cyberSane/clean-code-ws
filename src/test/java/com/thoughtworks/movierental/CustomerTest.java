package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    @Test
    public void testStatementGeneration() {
        Customer customer = new Customer("Akshay");
        customer.addRental(new Rental(new Movie("KKKG", Movie.REGULAR), 4));
        customer.addRental(new Rental(new Movie("Drive", Movie.NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("Zero", Movie.CHILDRENS), 2));
        customer.addRental(new Rental(new Movie("Avatar", Movie.BLURAY), 2));
        String actualStatement = customer.statement();
        String expectedStatement = "Rental Record for Akshay\n" +
                "\tKKKG\t5.0\n" +
                "\tDrive\t9.0\n" +
                "\tZero\t1.5\n" +
                "\tAvatar\t8.0\n" +
                "Amount owed is 23.5\n" +
                "You earned 7 frequent renter points";
        Assert.assertEquals(expectedStatement, actualStatement);
    }

    @Test
    public void shouldGenerateHTMLStatement() {
        Customer customer = new Customer("Akshay");
        customer.addRental(new Rental(new Movie("KKKG", Movie.REGULAR), 4));
        customer.addRental(new Rental(new Movie("Drive", Movie.NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("Zero", Movie.CHILDRENS), 2));
        customer.addRental(new Rental(new Movie("Avatar", Movie.BLURAY), 2));
        String actualStatement = customer.htmlStatement();
        String expectedStatement = "<h1>Rental Record for <b>Akshay</b></h1><br/>" +
                "KKKG 5.0<br/>" +
                "Drive 9.0<br/>" +
                "Zero 1.5<br/>" +
                "Avatar 8.0<br/>" +
                "Amount owed is <b>23.5<b><br/>" +
                "You earned <b>7</b> frequent renter points";
        Assert.assertEquals(expectedStatement, actualStatement);
    }
}