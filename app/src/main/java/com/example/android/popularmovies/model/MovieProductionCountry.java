package com.example.android.popularmovies.model;

public class MovieProductionCountry {
    private final String ISO3166_1;
    private final String name;

    public MovieProductionCountry(String countryCode, String name) {
        this.ISO3166_1 = countryCode;
        this.name = name;
    }

    public String getCountryCode() {
        return ISO3166_1;
    }

    public String getName() {
        return name;
    }
}
