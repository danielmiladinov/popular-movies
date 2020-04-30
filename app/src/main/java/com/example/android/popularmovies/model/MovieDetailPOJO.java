package com.example.android.popularmovies.model;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailPOJO implements MovieDetail {
    private final Long id;
    private final String title;
    private final String originalTitle;
    private final String originalLanguage;
    private final String releaseDate;
    private final String overview;
    private final String posterPath;
    private final String backdropPath;
    private final Boolean video;
    private final Boolean adult;
    private final Double popularity;
    private final Long voteCount;
    private final Double voteAverage;
    private final MovieCollectionSummary belongsToCollection;
    private final Long budget;
    private final List<MovieGenre> genres;
    private final String homepage;
    private final String imdbId;
    private final List<MovieProductionCompany> productionCompanies;
    private final List<MovieProductionCountry> productionCountries;
    private final Long revenue;
    private final Long runtime;
    private final List<SpokenLanguage> spokenLanguages;
    private final MovieDetail.Status status;
    private final String tagline;

    public MovieDetailPOJO(
        Long id, String title, String originalTitle, String originalLanguage, String releaseDate,
        String overview, String posterPath, String backdropPath, Boolean video, Boolean adult,
        Double popularity, Long voteCount, Double voteAverage,
        MovieCollectionSummary belongsToCollection, Long budget, List<MovieGenre> genres,
        String homepage, String imdbId, List<MovieProductionCompany> productionCompanies,
        List<MovieProductionCountry> productionCountries, Long revenue, Long runtime,
        List<SpokenLanguage> spokenLanguages, Status status, String tagline
    ) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.originalLanguage = originalLanguage;
        this.releaseDate = releaseDate;
        this.overview = overview;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.video = video;
        this.adult = adult;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
        this.genres = genres;
        this.belongsToCollection = belongsToCollection;
        this.budget = budget;
        this.homepage = homepage;
        this.imdbId = imdbId;
        this.productionCompanies = productionCompanies;
        this.productionCountries = productionCountries;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spokenLanguages = spokenLanguages;
        this.status = status;
        this.tagline = tagline;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getOriginalTitle() {
        return originalTitle;
    }

    @Override
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    @Override
    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String getOverview() {
        return overview;
    }

    @Override
    public String getPosterPath() {
        return posterPath;
    }

    @Override
    public String getBackdropPath() {
        return backdropPath;
    }

    @Override
    public List<Long> getGenreIds() {
        List<Long> genreIds = new ArrayList<>(genres.size());

        for (MovieGenre mg : genres) {
            genreIds.add(mg.getId());
        }

        return genreIds;
    }

    @Override
    public Boolean getVideo() {
        return video;
    }

    @Override
    public Boolean getAdult() {
        return adult;
    }

    @Override
    public Double getPopularity() {
        return popularity;
    }

    @Override
    public Long getVoteCount() {
        return voteCount;
    }

    @Override
    public Double getVoteAverage() {
        return voteAverage;
    }

    @Override
    public MovieCollectionSummary getMovieCollection() {
        return belongsToCollection;
    }

    @Override
    public Long getBudget() {
        return budget;
    }

    @Override
    public List<MovieGenre> getGenres() {
        return genres;
    }

    @Override
    public String getHomepage() {
        return homepage;
    }

    @Override
    public String getImdbId() {
        return imdbId;
    }

    @Override
    public List<MovieProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    @Override
    public List<MovieProductionCountry> getProductionCountries() {
        return productionCountries;
    }

    @Override
    public Long getRevenue() {
        return revenue;
    }

    @Override
    public Long getRuntime() {
        return runtime;
    }

    @Override
    public List<SpokenLanguage> getSpokenLanguages() {
        return spokenLanguages;
    }

    @Override
    public MovieDetail.Status getStatus() {
        return status;
    }

    @Override
    public String getTagline() {
        return tagline;
    }
}
