package com.example.android.popularmovies.model;

public class MovieGenre {
    private final Long id;
    private final String name;

    public MovieGenre(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
