package com.example.android.popularmovies.model;

public class MovieProductionCompany {
    private final Long id;
    private final String name;
    private final String originCountry;
    private final String logoPath;

    public MovieProductionCompany(Long id, String name, String originCountry, String logoPath) {
        this.id = id;
        this.name = name;
        this.originCountry = originCountry;
        this.logoPath = logoPath;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public String getLogoPath() {
        return logoPath;
    }
}
