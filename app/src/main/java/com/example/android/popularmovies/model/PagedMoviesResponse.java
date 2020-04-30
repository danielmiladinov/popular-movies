package com.example.android.popularmovies.model;

import java.util.List;

public class PagedMoviesResponse {
    private final Long page;
    private final Long totalResults;
    private final Long totalPages;
    private final List<MovieSummary> results;

    public PagedMoviesResponse(Long page, Long totalResults, Long totalPages, List<MovieSummary> results) {
        this.page = page;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
        this.results = results;
    }

    public Long getPage() {
        return page;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public List<MovieSummary> getResults() {
        return results;
    }
}
