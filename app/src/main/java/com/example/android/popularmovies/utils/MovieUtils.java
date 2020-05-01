package com.example.android.popularmovies.utils;

import android.text.TextUtils;
import android.util.Log;

import com.example.android.popularmovies.model.MovieSummary;

public class MovieUtils {
    private static final String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/";
    private static final int[] posterSizes = new int[] { 780, 500, 342, 185, 154, 92 };

    public static String absolutePosterImagePathOf(MovieSummary m, int desiredImageWidth) {
        String imageWidthPathParam;

        if (desiredImageWidth > 0) {
            int smallestSizeGreaterThanDesiredWidth = posterSizes[0];

            if (desiredImageWidth > smallestSizeGreaterThanDesiredWidth) {
                imageWidthPathParam = "original";
            } else {
                int i = 1;
                while (desiredImageWidth < posterSizes[i]) {
                    smallestSizeGreaterThanDesiredWidth = posterSizes[i++];
                }
                imageWidthPathParam = "w" + smallestSizeGreaterThanDesiredWidth;
            }
        } else {
            imageWidthPathParam = "w185";
        }

        Log.d(MovieUtils.class.getSimpleName(), String.format("absolutePosterImagePathOf(%s)", m));

        String[] parts = { BASE_IMAGE_URL, imageWidthPathParam, m.getPosterPath() };
        String posterImagePath = TextUtils.join("", parts);

        Log.d(
            MovieUtils.class.getSimpleName(),
            String.format("movie: %s; poster image path: '%s'", m, posterImagePath)
        );

        return posterImagePath;
    }
}
