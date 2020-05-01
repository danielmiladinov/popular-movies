package com.example.android.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieCollectionSummary implements Parcelable {
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

    private MovieCollectionSummary(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        name = in.readString();
        posterPath = in.readString();
        backdropPath = in.readString();
    }

    public static final Creator<MovieCollectionSummary> CREATOR = new Creator<MovieCollectionSummary>() {
        @Override
        public MovieCollectionSummary createFromParcel(Parcel in) {
            return new MovieCollectionSummary(in);
        }

        @Override
        public MovieCollectionSummary[] newArray(int size) {
            return new MovieCollectionSummary[size];
        }
    };

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
        dest.writeString(name);
        dest.writeString(posterPath);
        dest.writeString(backdropPath);
    }
}
