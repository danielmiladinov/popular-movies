package com.example.android.popularmovies.model;

import java.util.List;

public class PopularMoviesResponse {
    private final Integer page;
    private final Integer totalResults;
    private final Integer totalPages;
    private final List<Movie> results;

    public PopularMoviesResponse(Integer page, Integer totalResults, Integer totalPages, List<Movie> results) {
        this.page = page;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public List<Movie> getResults() {
        return results;
    }
}
