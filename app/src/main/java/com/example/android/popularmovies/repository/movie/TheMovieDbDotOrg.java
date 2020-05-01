package com.example.android.popularmovies.repository.movie;

import android.net.Uri;
import android.text.TextUtils;

import com.example.android.popularmovies.model.MovieDetail;
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
        String apiResponse = getApiResponse(apiKey, POPULAR, page);
        return JsonUtils.pagedMoviesResponseFrom(apiResponse);
    }

    public static PagedMoviesResponse getTopRatedMovies(String apiKey, int page) throws IOException {
        String apiResponse = getApiResponse(apiKey, TOP_RATED, page);
        return JsonUtils.pagedMoviesResponseFrom(apiResponse);
    }

    public static MovieDetail getMovieDetail(String apiKey, long movieId) throws IOException {
        String apiResponse = getApiResponse(apiKey, String.valueOf(movieId), 0);
        return JsonUtils.movieDetailFrom(apiResponse);
    }

    private static String getApiResponse(String apiKey, String type, int page) throws IOException {
        Uri.Builder builder = Uri.parse(TextUtils.join("/", new String[]{BASE_URL, type}))
            .buildUpon()
            .appendQueryParameter("language", LANGUAGE)
            .appendQueryParameter("api_key", apiKey);

        if (page > 0) {
            builder.appendQueryParameter("page", String.valueOf(page));
        }

        Uri builtUri = builder.build();

        URL url = new URL(builtUri.toString());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            Scanner scanner = new Scanner(urlConnection.getInputStream());
            scanner.useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : null;
        } finally {
            urlConnection.disconnect();
        }
    }
}
