package com.example.android.popularmovies.model;

import androidx.annotation.NonNull;

import java.util.List;

public class MovieSummaryPOJO implements MovieSummary {
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

    public MovieSummaryPOJO(
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

    @NonNull
    @Override
    public String toString() {
        return "MovieSummary{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", originalTitle='" + originalTitle + '\'' +
            ", originalLanguage='" + originalLanguage + '\'' +
            ", releaseDate='" + releaseDate + '\'' +
            ", overview='" + overview + '\'' +
            ", posterPath='" + posterPath + '\'' +
            ", backdropPath='" + backdropPath + '\'' +
            ", genreIds=" + genreIds +
            ", video=" + video +
            ", adult=" + adult +
            ", popularity=" + popularity +
            ", voteCount=" + voteCount +
            ", voteAverage=" + voteAverage +
            '}';
    }
}
