package com.example.android.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

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

    enum Status implements Parcelable {
        Rumored, Planned, InProduction, PostProduction, Released, Canceled;

        public static final Creator<Status> CREATOR = new Creator<Status>() {
            @Override
            public Status createFromParcel(Parcel in) {
                return Status.valueOf(in.readString());
            }

            @Override
            public Status[] newArray(int size) {
                return new Status[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.name());
        }
    }
}
