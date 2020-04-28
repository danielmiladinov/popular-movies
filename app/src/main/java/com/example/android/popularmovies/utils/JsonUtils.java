package com.example.android.popularmovies.utils;

import com.example.android.popularmovies.model.Movie;
import com.example.android.popularmovies.model.PopularMoviesResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static final String POPULAR_MOVIES_RESPONSE_PROPERTY_PAGE = "page";
    private static final String POPULAR_MOVIES_RESPONSE_PROPERTY_TOTAL_RESULTS = "total_results";
    private static final String POPULAR_MOVIES_RESPONSE_PROPERTY_TOTAL_PAGES = "total_pages";
    private static final String POPULAR_MOVIES_RESPONSE_PROPERTY_RESULTS = "results";

    private static final String MOVIE_PROPERTY_ID = "id";
    private static final String MOVIE_PROPERTY_TITLE = "title";
    private static final String MOVIE_PROPERTY_ORIGINAL_TITLE = "original_title";
    private static final String MOVIE_PROPERTY_ORIGINAL_LANGUAGE = "original_language";
    private static final String MOVIE_PROPERTY_RELEASE_DATE = "release_date";
    private static final String MOVIE_PROPERTY_OVERVIEW = "overview";
    private static final String MOVIE_PROPERTY_POSTER_PATH = "poster_path";
    private static final String MOVIE_PROPERTY_BACKDROP_PATH = "backdrop_path";
    private static final String MOVIE_PROPERTY_GENRE_IDS = "genre_ids";
    private static final String MOVIE_PROPERTY_VIDEO = "video";
    private static final String MOVIE_PROPERTY_ADULT = "adult";
    private static final String MOVIE_PROPERTY_POPULARITY = "popularity";
    private static final String MOVIE_PROPERTY_VOTE_COUNT = "vote_count";
    private static final String MOVIE_PROPERTY_VOTE_AVERAGE = "vote_average";

    public static PopularMoviesResponse popularMoviesResponseFrom(String json) {
        try {
            JSONObject responseJson = new JSONObject(json);
            Integer page = responseJson.getInt(POPULAR_MOVIES_RESPONSE_PROPERTY_PAGE);
            Integer totalResults = responseJson.getInt(POPULAR_MOVIES_RESPONSE_PROPERTY_TOTAL_RESULTS);
            Integer totalPages = responseJson.getInt(POPULAR_MOVIES_RESPONSE_PROPERTY_TOTAL_PAGES);

            JSONArray resultsJson = responseJson.getJSONArray(POPULAR_MOVIES_RESPONSE_PROPERTY_RESULTS);
            List<Movie> results = moviesFrom(resultsJson);

            return new PopularMoviesResponse(page, totalResults, totalPages, results);

        } catch (JSONException je) {
            return null;
        }
    }

    private static List<Movie> moviesFrom(JSONArray resultsJson) throws JSONException {
        List<Movie> results = new ArrayList<>(resultsJson.length());

        for (int i = 0; i < resultsJson.length(); i++) {
            results.add(i, movieFrom(resultsJson.getJSONObject(i)));
        }

        return results;
    }

    private static Movie movieFrom(JSONObject movieJson) throws JSONException {
        Integer id = movieJson.getInt(MOVIE_PROPERTY_ID);
        String title = movieJson.getString(MOVIE_PROPERTY_TITLE);
        String originalTitle = movieJson.getString(MOVIE_PROPERTY_ORIGINAL_TITLE);
        String originalLanguage = movieJson.getString(MOVIE_PROPERTY_ORIGINAL_LANGUAGE);
        String releaseDate = movieJson.getString(MOVIE_PROPERTY_RELEASE_DATE);
        String overview = movieJson.getString(MOVIE_PROPERTY_OVERVIEW);
        String posterPath = movieJson.getString(MOVIE_PROPERTY_POSTER_PATH);
        String backdropPath = movieJson.getString(MOVIE_PROPERTY_BACKDROP_PATH);
        List<Integer> genreIds = genreIdsFrom(movieJson.getJSONArray(MOVIE_PROPERTY_GENRE_IDS));
        Boolean video = movieJson.getBoolean(MOVIE_PROPERTY_VIDEO);
        Boolean adult = movieJson.getBoolean(MOVIE_PROPERTY_ADULT);
        Double popularity = movieJson.getDouble(MOVIE_PROPERTY_POPULARITY);
        Integer voteCount = movieJson.getInt(MOVIE_PROPERTY_VOTE_COUNT);
        Double voteAverage = movieJson.getDouble(MOVIE_PROPERTY_VOTE_AVERAGE);

        return new Movie(
            id, title, originalTitle, originalLanguage, releaseDate, overview, posterPath,
            backdropPath, genreIds, video, adult, popularity, voteCount, voteAverage
        );
    }

    private static List<Integer> genreIdsFrom(JSONArray genreIdsJson) throws JSONException {
        List<Integer> genreIds = new ArrayList<>(genreIdsJson.length());

        for (int i = 0; i < genreIdsJson.length(); i++) {
            genreIds.add(i, genreIdsJson.getInt(i));
        }

        return genreIds;
    }
}
