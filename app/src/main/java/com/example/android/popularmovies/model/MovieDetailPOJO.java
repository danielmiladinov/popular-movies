package com.example.android.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailPOJO implements MovieDetail, Parcelable {
    public static final int INSTANCE_SIZE_IN_BYTES = 216;

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

    protected MovieDetailPOJO(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        title = in.readString();
        originalTitle = in.readString();
        originalLanguage = in.readString();
        releaseDate = in.readString();
        overview = in.readString();
        posterPath = in.readString();
        backdropPath = in.readString();
        byte tmpVideo = in.readByte();
        video = tmpVideo == 0 ? null : tmpVideo == 1;
        byte tmpAdult = in.readByte();
        adult = tmpAdult == 0 ? null : tmpAdult == 1;
        if (in.readByte() == 0) {
            popularity = null;
        } else {
            popularity = in.readDouble();
        }
        if (in.readByte() == 0) {
            voteCount = null;
        } else {
            voteCount = in.readLong();
        }
        if (in.readByte() == 0) {
            voteAverage = null;
        } else {
            voteAverage = in.readDouble();
        }
        belongsToCollection = in.readParcelable(MovieCollectionSummary.class.getClassLoader());
        if (in.readByte() == 0) {
            budget = null;
        } else {
            budget = in.readLong();
        }
        genres = in.createTypedArrayList(MovieGenre.CREATOR);
        homepage = in.readString();
        imdbId = in.readString();
        productionCompanies = in.createTypedArrayList(MovieProductionCompany.CREATOR);
        productionCountries = in.createTypedArrayList(MovieProductionCountry.CREATOR);
        if (in.readByte() == 0) {
            revenue = null;
        } else {
            revenue = in.readLong();
        }
        if (in.readByte() == 0) {
            runtime = null;
        } else {
            runtime = in.readLong();
        }
        spokenLanguages = in.createTypedArrayList(SpokenLanguage.CREATOR);
        status = in.readParcelable(Status.class.getClassLoader());
        tagline = in.readString();
    }

    public static final Creator<MovieDetailPOJO> CREATOR = new Creator<MovieDetailPOJO>() {
        @Override
        public MovieDetailPOJO createFromParcel(Parcel in) {
            return new MovieDetailPOJO(in);
        }

        @Override
        public MovieDetailPOJO[] newArray(int size) {
            return new MovieDetailPOJO[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeString(title);
        dest.writeString(originalTitle);
        dest.writeString(originalLanguage);
        dest.writeString(releaseDate);
        dest.writeString(overview);
        dest.writeString(posterPath);
        dest.writeString(backdropPath);
        dest.writeByte((byte) (video == null ? 0 : video ? 1 : 2));
        dest.writeByte((byte) (adult == null ? 0 : adult ? 1 : 2));
        if (popularity == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(popularity);
        }
        if (voteCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(voteCount);
        }
        if (voteAverage == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(voteAverage);
        }
        dest.writeParcelable(belongsToCollection, flags);
        if (budget == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(budget);
        }
        dest.writeTypedList(genres);
        dest.writeString(homepage);
        dest.writeString(imdbId);
        dest.writeTypedList(productionCompanies);
        dest.writeTypedList(productionCountries);
        if (revenue == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(revenue);
        }
        if (runtime == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(runtime);
        }
        dest.writeTypedList(spokenLanguages);
        dest.writeParcelable(status, flags);
        dest.writeString(tagline);
    }
}
