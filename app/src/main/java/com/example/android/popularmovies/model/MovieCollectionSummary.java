package com.example.android.popularmovies.model;

public class MovieCollectionSummary {
    private final Long id;
    private final String name;
    private final String posterPath;
    private final String backdropPath;

    public MovieCollectionSummary(Long id, String name, String posterPath, String backdropPath) {
        this.id = id;
        this.name = name;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }
}
