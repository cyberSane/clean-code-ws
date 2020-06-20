package com.thoughtworks.movierental;

public class Rental {

    private final int BONUS_FREQUENT_RENTER_POINT = 2;
    private final int FREQUENT_RENTER_POINT = 1;
    private int daysRented;
    Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double amount() {
        double totalAmount = 0;
        switch (movie.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                totalAmount += 2;
                if (daysRented > 2)
                    totalAmount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                totalAmount += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                totalAmount += 1.5;
                if (daysRented > 3)
                    totalAmount += (daysRented - 3) * 1.5;
                break;
        }
        return totalAmount;
    }

    int frequentRenterPoints() {
        return isBonusApplicable() ? BONUS_FREQUENT_RENTER_POINT : FREQUENT_RENTER_POINT;
    }

    private boolean isBonusApplicable() {
        return movie.isNewRelease() && getDaysRented() > 1;
    }
}