package com.example.android.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieProductionCountry implements Parcelable {
    private final String ISO3166_1;
    private final String name;

    public MovieProductionCountry(String countryCode, String name) {
        this.ISO3166_1 = countryCode;
        this.name = name;
    }

    private MovieProductionCountry(Parcel in) {
        ISO3166_1 = in.readString();
        name = in.readString();
    }

    public static final Creator<MovieProductionCountry> CREATOR = new Creator<MovieProductionCountry>() {
        @Override
        public MovieProductionCountry createFromParcel(Parcel in) {
            return new MovieProductionCountry(in);
        }

        @Override
        public MovieProductionCountry[] newArray(int size) {
            return new MovieProductionCountry[size];
        }
    };

    public String getCountryCode() {
        return ISO3166_1;
    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ISO3166_1);
        dest.writeString(name);
    }
}
