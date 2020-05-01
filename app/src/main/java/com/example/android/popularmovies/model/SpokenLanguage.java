package com.example.android.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SpokenLanguage implements Parcelable {
    private final String ISO639_1;
    private final String name;

    public SpokenLanguage(String languageCode, String name) {
        ISO639_1 = languageCode;
        this.name = name;
    }

    private SpokenLanguage(Parcel in) {
        ISO639_1 = in.readString();
        name = in.readString();
    }

    public static final Creator<SpokenLanguage> CREATOR = new Creator<SpokenLanguage>() {
        @Override
        public SpokenLanguage createFromParcel(Parcel in) {
            return new SpokenLanguage(in);
        }

        @Override
        public SpokenLanguage[] newArray(int size) {
            return new SpokenLanguage[size];
        }
    };

    public String getLanguageCode() {
        return ISO639_1;
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
        dest.writeString(ISO639_1);
        dest.writeString(name);
    }
}
