package com.example.android.popularmovies.model;

import java.util.List;

public interface MovieDetail extends MovieSummary {
    MovieCollectionSummary getMovieCollection();

    Long getBudget();

    List<MovieGenre> getGenres();

    String getHomepage();

    String getImdbId();

    List<MovieProductionCompany> getProductionCompanies();

    List<MovieProductionCountry> getProductionCountries();

    Long getRevenue();

    Long getRuntime();

    List<SpokenLanguage> getSpokenLanguages();

    MovieDetail.Status getStatus();

    String getTagline();

    enum Status {
        Rumored, Planned, InProduction, PostProduction, Released, Canceled
    }
}
