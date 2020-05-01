package com.example.android.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieProductionCompany implements Parcelable {
    private final Long id;
    private final String name;
    private final String originCountry;
    private final String logoPath;

    public MovieProductionCompany(Long id, String name, String originCountry, String logoPath) {
        this.id = id;
        this.name = name;
        this.originCountry = originCountry;
        this.logoPath = logoPath;
    }

    private MovieProductionCompany(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        name = in.readString();
        originCountry = in.readString();
        logoPath = in.readString();
    }

    public static final Creator<MovieProductionCompany> CREATOR = new Creator<MovieProductionCompany>() {
        @Override
        public MovieProductionCompany createFromParcel(Parcel in) {
            return new MovieProductionCompany(in);
        }

        @Override
        public MovieProductionCompany[] newArray(int size) {
            return new MovieProductionCompany[size];
        }
    };

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public String getLogoPath() {
        return logoPath;
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
        dest.writeString(originCountry);
        dest.writeString(logoPath);
    }
}
