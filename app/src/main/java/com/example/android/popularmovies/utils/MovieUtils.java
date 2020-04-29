package com.example.android.popularmovies.utils;

import android.text.TextUtils;

import com.example.android.popularmovies.model.Movie;

public class MovieUtils {
    private static final String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/";

    public static String absolutePosterImagePathOf(Movie m) {
        String[] parts = { BASE_IMAGE_URL, "w185", m.getPosterPath() };
        return TextUtils.join("", parts);
    }
}
