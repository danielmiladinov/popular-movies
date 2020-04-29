package com.example.android.popularmovies.model;

import java.util.List;

public class Movie {
    private final Long id;
    private final String title;
    private final String originalTitle;
    private final String originalLanguage;
    private final String releaseDate;
    private final String overview;
    private final String posterPath;
    private final String backdropPath;
    private final List<Long> genreIds;
    private final Boolean video;
    private final Boolean adult;
    private final Double popularity;
    private final Long voteCount;
    private final Double voteAverage;

    public Movie(
        Long id, String title, String originalTitle, String originalLanguage, String releaseDate,
        String overview, String posterPath, String backdropPath, List<Long> genreIds,
        Boolean video, Boolean adult, Double popularity, Long voteCount, Double voteAverage
    ) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.originalLanguage = originalLanguage;
        this.releaseDate = releaseDate;
        this.overview = overview;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.genreIds = genreIds;
        this.video = video;
        this.adult = adult;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public List<Long> getGenreIds() {
        return genreIds;
    }

    public Boolean getVideo() {
        return video;
    }

    public Boolean getAdult() {
        return adult;
    }

    public Double getPopularity() {
        return popularity;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }
}
