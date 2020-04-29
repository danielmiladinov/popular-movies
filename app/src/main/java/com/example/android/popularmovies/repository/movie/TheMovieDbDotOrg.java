package com.example.android.popularmovies.repository.movie;

import android.net.Uri;
import android.text.TextUtils;

import com.example.android.popularmovies.model.PagedMoviesResponse;
import com.example.android.popularmovies.utils.JsonUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class TheMovieDbDotOrg {
    private static final String BASE_URL = "https://api.themoviedb.org/3/movie";
    private static final String POPULAR = "popular";
    private static final String TOP_RATED = "top_rated";
    private static final String LANGUAGE = "en-US";

    public static PagedMoviesResponse getPopularMovies(String apiKey, int page) throws IOException {
        return getPopularMoviesResponse(POPULAR, apiKey, page);
    }

    public static PagedMoviesResponse getTopRatedMovies(String apiKey, int page) throws IOException {
        return getPopularMoviesResponse(TOP_RATED, apiKey, page);
    }

    private static PagedMoviesResponse getPopularMoviesResponse(String type, String apiKey, int page) throws IOException {
        Uri builtUri = Uri.parse(TextUtils.join("/", new String[]{ BASE_URL, type}))
            .buildUpon()
            .appendQueryParameter("language", LANGUAGE)
            .appendQueryParameter("page", String.valueOf(page))
            .appendQueryParameter("api_key", apiKey)
            .build();

        URL url = new URL(builtUri.toString());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            Scanner scanner = new Scanner(urlConnection.getInputStream());
            scanner.useDelimiter("\\A");
            String json = scanner.hasNext() ? scanner.next() : null;
            return JsonUtils.pagedMoviesResponseFrom(json);
        } finally {
            urlConnection.disconnect();
        }
    }
}
