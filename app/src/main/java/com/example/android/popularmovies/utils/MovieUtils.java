package com.example.android.popularmovies.utils;

import android.text.TextUtils;
import android.util.Log;

import com.example.android.popularmovies.model.Movie;

public class MovieUtils {
    private static final String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/";

    public static String absolutePosterImagePathOf(Movie m) {
        Log.d(MovieUtils.class.getSimpleName(), String.format("absolutePosterImagePathOf(%s)", m));

        String[] parts = { BASE_IMAGE_URL, "w185", m.getPosterPath() };
        String posterImagePath = TextUtils.join("", parts);

        Log.d(
            MovieUtils.class.getSimpleName(),
            String.format("movie: %s; poster image path: '%s'", m, posterImagePath)
        );

        return posterImagePath;
    }
}
