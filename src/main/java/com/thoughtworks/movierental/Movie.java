package com.thoughtworks.movierental;

public class Movie {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;
    public static final int BLURAY = 3;

    private String title;
    private int priceCode;
    private boolean blueRay;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }

    boolean isNewRelease() {
        return priceCode == Movie.NEW_RELEASE;
    }

    public boolean isBlueRay() {
        return priceCode == Movie.BLURAY;
    }

    public Price price() {
        switch (getPriceCode()) {
            case REGULAR:
                return new RegularPrice();
            case NEW_RELEASE:
                return new NewReleasePrice();
            case CHILDRENS:
                return new ChildrenPrice();
            case BLURAY:
                return new BluRayPrice();
            default:
                return new DefaultPrice();
        }
    }
}