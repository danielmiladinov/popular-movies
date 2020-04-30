package com.example.android.popularmovies.model;

public class SpokenLanguage {
    private final String ISO639_1;
    private final String name;

    public SpokenLanguage(String languageCode, String name) {
        ISO639_1 = languageCode;
        this.name = name;
    }

    public String getLanguageCode() {
        return ISO639_1;
    }

    public String getName() {
        return name;
    }
}
