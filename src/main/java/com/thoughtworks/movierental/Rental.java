package com.thoughtworks.movierental;

public class Rental {

    private final int BONUSNOTAPPLICABLE = 1;
    private final int NEW_RELEASE_BONUS = 2;
    private final int BLURAY_BONUS = 3;

    private int daysRented;
    private Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double amount() {
        return movie.price().amount(daysRented);
    }

    public int frequentRenter() {
        if(movie.isNewRelease()) {
            return daysRented > 1 ? NEW_RELEASE_BONUS : BONUSNOTAPPLICABLE;
        } else if(movie.isBlueRay()) {
            return BLURAY_BONUS;
        } else {
            return BONUSNOTAPPLICABLE;
        }
    }
}