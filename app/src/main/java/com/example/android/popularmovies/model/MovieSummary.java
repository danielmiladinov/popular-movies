package com.example.android.popularmovies.model;

import java.util.List;

public interface MovieSummary {
    Long getId();

    String getTitle();

    String getOriginalTitle();

    String getOriginalLanguage();

    String getReleaseDate();

    String getOverview();

    String getPosterPath();

    String getBackdropPath();

    List<Long> getGenreIds();

    Boolean getVideo();

    Boolean getAdult();

    Double getPopularity();

    Long getVoteCount();

    Double getVoteAverage();
}
