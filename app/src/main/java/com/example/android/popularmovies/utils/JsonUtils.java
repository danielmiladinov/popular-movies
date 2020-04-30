package com.example.android.popularmovies.utils;

import com.example.android.popularmovies.model.MovieSummary;
import com.example.android.popularmovies.model.MovieSummaryPOJO;
import com.example.android.popularmovies.model.PagedMoviesResponse;

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

    private static final String MOVIE_SUMMARY_PROPERTY_ID = "id";
    private static final String MOVIE_SUMMARY_PROPERTY_TITLE = "title";
    private static final String MOVIE_SUMMARY_PROPERTY_ORIGINAL_TITLE = "original_title";
    private static final String MOVIE_SUMMARY_PROPERTY_ORIGINAL_LANGUAGE = "original_language";
    private static final String MOVIE_SUMMARY_PROPERTY_RELEASE_DATE = "release_date";
    private static final String MOVIE_SUMMARY_PROPERTY_OVERVIEW = "overview";
    private static final String MOVIE_SUMMARY_PROPERTY_POSTER_PATH = "poster_path";
    private static final String MOVIE_SUMMARY_PROPERTY_BACKDROP_PATH = "backdrop_path";
    private static final String MOVIE_SUMMARY_PROPERTY_GENRE_IDS = "genre_ids";
    private static final String MOVIE_SUMMARY_PROPERTY_VIDEO = "video";
    private static final String MOVIE_SUMMARY_PROPERTY_ADULT = "adult";
    private static final String MOVIE_SUMMARY_PROPERTY_POPULARITY = "popularity";
    private static final String MOVIE_SUMMARY_PROPERTY_VOTE_COUNT = "vote_count";
    private static final String MOVIE_SUMMARY_PROPERTY_VOTE_AVERAGE = "vote_average";

    public static PagedMoviesResponse pagedMoviesResponseFrom(String json) {
        try {
            JSONObject responseJson = new JSONObject(json);
            Long page = responseJson.getLong(POPULAR_MOVIES_RESPONSE_PROPERTY_PAGE);
            Long totalResults = responseJson.getLong(POPULAR_MOVIES_RESPONSE_PROPERTY_TOTAL_RESULTS);
            Long totalPages = responseJson.getLong(POPULAR_MOVIES_RESPONSE_PROPERTY_TOTAL_PAGES);

            JSONArray resultsJson = responseJson.getJSONArray(POPULAR_MOVIES_RESPONSE_PROPERTY_RESULTS);
            List<MovieSummary> results = moviesFrom(resultsJson);

            return new PagedMoviesResponse(page, totalResults, totalPages, results);

        } catch (JSONException je) {
            return null;
        }
    }

    private static List<MovieSummary> moviesFrom(JSONArray resultsJson) throws JSONException {
        List<MovieSummary> results = new ArrayList<>(resultsJson.length());

        for (int i = 0; i < resultsJson.length(); i++) {
            results.add(i, movieFrom(resultsJson.getJSONObject(i)));
        }

        return results;
    }

    private static MovieSummary movieFrom(JSONObject movieJson) throws JSONException {
        Long id = movieJson.getLong(MOVIE_SUMMARY_PROPERTY_ID);
        String title = movieJson.getString(MOVIE_SUMMARY_PROPERTY_TITLE);
        String originalTitle = movieJson.getString(MOVIE_SUMMARY_PROPERTY_ORIGINAL_TITLE);
        String originalLanguage = movieJson.getString(MOVIE_SUMMARY_PROPERTY_ORIGINAL_LANGUAGE);
        String releaseDate = movieJson.getString(MOVIE_SUMMARY_PROPERTY_RELEASE_DATE);
        String overview = movieJson.getString(MOVIE_SUMMARY_PROPERTY_OVERVIEW);
        String posterPath = movieJson.getString(MOVIE_SUMMARY_PROPERTY_POSTER_PATH);
        String backdropPath = movieJson.getString(MOVIE_SUMMARY_PROPERTY_BACKDROP_PATH);
        List<Long> genreIds = genreIdsFrom(movieJson.getJSONArray(MOVIE_SUMMARY_PROPERTY_GENRE_IDS));
        Boolean video = movieJson.getBoolean(MOVIE_SUMMARY_PROPERTY_VIDEO);
        Boolean adult = movieJson.getBoolean(MOVIE_SUMMARY_PROPERTY_ADULT);
        Double popularity = movieJson.getDouble(MOVIE_SUMMARY_PROPERTY_POPULARITY);
        Long voteCount = movieJson.getLong(MOVIE_SUMMARY_PROPERTY_VOTE_COUNT);
        Double voteAverage = movieJson.getDouble(MOVIE_SUMMARY_PROPERTY_VOTE_AVERAGE);

        return new MovieSummaryPOJO(
            id, title, originalTitle, originalLanguage, releaseDate, overview, posterPath,
            backdropPath, genreIds, video, adult, popularity, voteCount, voteAverage
        );
    }

    private static List<Long> genreIdsFrom(JSONArray genreIdsJson) throws JSONException {
        List<Long> genreIds = new ArrayList<>(genreIdsJson.length());

        for (int i = 0; i < genreIdsJson.length(); i++) {
            genreIds.add(i, genreIdsJson.getLong(i));
        }

        return genreIds;
    }
}
