package com.example.android.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieGenre implements Parcelable {
    private final Long id;
    private final String name;

    public MovieGenre(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    private MovieGenre(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        name = in.readString();
    }

    public static final Creator<MovieGenre> CREATOR = new Creator<MovieGenre>() {
        @Override
        public MovieGenre createFromParcel(Parcel in) {
            return new MovieGenre(in);
        }

        @Override
        public MovieGenre[] newArray(int size) {
            return new MovieGenre[size];
        }
    };

    public Long getId() {
        return id;
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
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeString(name);
    }
}
