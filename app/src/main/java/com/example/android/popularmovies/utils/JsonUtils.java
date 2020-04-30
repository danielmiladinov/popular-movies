package com.example.android.popularmovies.utils;

import com.example.android.popularmovies.model.MovieCollectionSummary;
import com.example.android.popularmovies.model.MovieDetail;
import com.example.android.popularmovies.model.MovieDetailPOJO;
import com.example.android.popularmovies.model.MovieGenre;
import com.example.android.popularmovies.model.MovieProductionCompany;
import com.example.android.popularmovies.model.MovieProductionCountry;
import com.example.android.popularmovies.model.MovieSummary;
import com.example.android.popularmovies.model.MovieSummaryPOJO;
import com.example.android.popularmovies.model.PagedMoviesResponse;
import com.example.android.popularmovies.model.SpokenLanguage;

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

    private static final String MOVIE_DETAIL_PROPERTY_BELONGS_TO_COLLECTION = "belongs_to_collection";
    private static final String MOVIE_DETAIL_PROPERTY_BUDGET = "budget";
    private static final String MOVIE_DETAIL_PROPERTY_GENRES = "genres";
    private static final String MOVIE_DETAIL_PROPERTY_HOMEPAGE = "homepage";
    private static final String MOVIE_DETAIL_PROPERTY_IMDB_ID = "imdb_id";
    private static final String MOVIE_DETAIL_PROPERTY_PRODUCTION_COMPANIES = "production_companies";
    private static final String MOVIE_DETAIL_PROPERTY_PRODUCTION_COUNTRIES = "production_countries";
    private static final String MOVIE_DETAIL_PROPERTY_REVENUE = "revenue";
    private static final String MOVIE_DETAIL_PROPERTY_RUNTIME = "runtime";
    private static final String MOVIE_DETAIL_PROPERTY_SPOKEN_LANGUAGES = "spoken_languages";
    private static final String MOVIE_DETAIL_PROPERTY_STATUS = "status";
    private static final String MOVIE_DETAIL_PROPERTY_TAGLINE = "tagline";

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

    public static MovieDetail movieDetailFrom(String json) {
        try {
            JSONObject detailJson = new JSONObject(json);
            Long id = detailJson.getLong(MOVIE_SUMMARY_PROPERTY_ID);
            String title = detailJson.getString(MOVIE_SUMMARY_PROPERTY_TITLE);
            String originalTitle = detailJson.getString(MOVIE_SUMMARY_PROPERTY_ORIGINAL_TITLE);
            String originalLanguage = detailJson.getString(MOVIE_SUMMARY_PROPERTY_ORIGINAL_LANGUAGE);
            String releaseDate = detailJson.getString(MOVIE_SUMMARY_PROPERTY_RELEASE_DATE);
            String overview = detailJson.getString(MOVIE_SUMMARY_PROPERTY_OVERVIEW);
            String posterPath = detailJson.getString(MOVIE_SUMMARY_PROPERTY_POSTER_PATH);
            String backdropPath = detailJson.getString(MOVIE_SUMMARY_PROPERTY_BACKDROP_PATH);
            Boolean video = detailJson.getBoolean(MOVIE_SUMMARY_PROPERTY_VIDEO);
            Boolean adult = detailJson.getBoolean(MOVIE_SUMMARY_PROPERTY_ADULT);
            Double popularity = detailJson.getDouble(MOVIE_SUMMARY_PROPERTY_POPULARITY);
            Long voteCount = detailJson.getLong(MOVIE_SUMMARY_PROPERTY_VOTE_COUNT);
            Double voteAverage = detailJson.getDouble(MOVIE_SUMMARY_PROPERTY_VOTE_AVERAGE);

            MovieCollectionSummary belongsToCollection = movieCollectionSummaryFrom(
                detailJson.optJSONObject(MOVIE_DETAIL_PROPERTY_BELONGS_TO_COLLECTION)
            );
            Long budget = detailJson.getLong(MOVIE_DETAIL_PROPERTY_BUDGET);
            List<MovieGenre> genres = genresFrom(
                detailJson.getJSONArray(MOVIE_DETAIL_PROPERTY_GENRES)
            );
            String homepage = detailJson.getString(MOVIE_DETAIL_PROPERTY_HOMEPAGE);
            String imdbId = detailJson.getString(MOVIE_DETAIL_PROPERTY_IMDB_ID);
            List<MovieProductionCompany> productionCompanies = productionCompaniesFrom(
                detailJson.getJSONArray(MOVIE_DETAIL_PROPERTY_PRODUCTION_COMPANIES)
            );
            List<MovieProductionCountry> productionCountries = productionCountriesFrom(
                detailJson.getJSONArray(MOVIE_DETAIL_PROPERTY_PRODUCTION_COUNTRIES)
            );
            Long revenue = detailJson.getLong(MOVIE_DETAIL_PROPERTY_REVENUE);
            Long runtime = detailJson.getLong(MOVIE_DETAIL_PROPERTY_RUNTIME);
            List<SpokenLanguage> spokenLanguages = spokenLanguagesFrom(
                detailJson.getJSONArray(MOVIE_DETAIL_PROPERTY_SPOKEN_LANGUAGES)
            );
            MovieDetail.Status status = movieStatusFrom(
                detailJson.getString(MOVIE_DETAIL_PROPERTY_STATUS)
            );
            String tagline = detailJson.getString(MOVIE_DETAIL_PROPERTY_TAGLINE);

            return new MovieDetailPOJO(
                id, title, originalTitle, originalLanguage, releaseDate, overview, posterPath,
                backdropPath, video, adult, popularity, voteCount, voteAverage, belongsToCollection,
                budget, genres, homepage, imdbId, productionCompanies, productionCountries, revenue,
                runtime, spokenLanguages, status, tagline
            );
        } catch (JSONException je) {
            return null;
        }
    }

    private static final String MOVIE_COLLECTION_SUMMARY_PROPERTY_ID = "id";
    private static final String MOVIE_COLLECTION_SUMMARY_PROPERTY_NAME = "name";
    private static final String MOVIE_COLLECTION_SUMMARY_PROPERTY_POSTER_PATH = "poster_path";
    private static final String MOVIE_COLLECTION_SUMMARY_PROPERTY_BACKDROP_PATH = "backdrop_path";

    private static MovieCollectionSummary movieCollectionSummaryFrom(JSONObject collectionJson) throws JSONException {
        if (collectionJson != null) {
            return new MovieCollectionSummary(
                collectionJson.getLong(MOVIE_COLLECTION_SUMMARY_PROPERTY_ID),
                collectionJson.getString(MOVIE_COLLECTION_SUMMARY_PROPERTY_NAME),
                collectionJson.getString(MOVIE_COLLECTION_SUMMARY_PROPERTY_POSTER_PATH),
                collectionJson.getString(MOVIE_COLLECTION_SUMMARY_PROPERTY_BACKDROP_PATH)
            );
        } else {
            return null;
        }
    }

    private static final String MOVIE_GENRE_PROPERTY_ID = "id";
    private static final String MOVIE_GENRE_PROPERTY_NAME = "name";

    private static List<MovieGenre> genresFrom(JSONArray genresJson) throws JSONException {
        List<MovieGenre> genres = new ArrayList<>(genresJson.length());
        for (int i = 0; i < genresJson.length(); i++) {
            JSONObject genreJson = genresJson.getJSONObject(i);
            genres.add(i, new MovieGenre(
                genreJson.getLong(MOVIE_GENRE_PROPERTY_ID),
                genreJson.getString(MOVIE_GENRE_PROPERTY_NAME)
            ));
        }
        return genres;
    }

    private static final String MOVIE_PRODUCTION_COMPANY_PROPERTY_ID = "id";
    private static final String MOVIE_PRODUCTION_COMPANY_PROPERTY_NAME = "name";
    private static final String MOVIE_PRODUCTION_COMPANY_PROPERTY_ORIGIN_COUNTRY = "origin_country";
    private static final String MOVIE_PRODUCTION_COMPANY_PROPERTY_LOGO_PATH = "logo_path";

    private static List<MovieProductionCompany> productionCompaniesFrom(JSONArray companiesJson) throws JSONException{
        List<MovieProductionCompany> companies = new ArrayList<>(companiesJson.length());
        for (int i = 0; i < companiesJson.length(); i++) {
            JSONObject companyJson = companiesJson.getJSONObject(i);
            companies.add(i, new MovieProductionCompany(
                companyJson.getLong(MOVIE_PRODUCTION_COMPANY_PROPERTY_ID),
                companyJson.getString(MOVIE_PRODUCTION_COMPANY_PROPERTY_NAME),
                companyJson.getString(MOVIE_PRODUCTION_COMPANY_PROPERTY_ORIGIN_COUNTRY),
                companyJson.getString(MOVIE_PRODUCTION_COMPANY_PROPERTY_LOGO_PATH)
            ));
        }
        return companies;
    }

    private static final String MOVIE_PRODUCTION_COUNTRY_PROPERTY_COUNTRY_CODE = "iso_3166_1";
    private static final String MOVIE_PRODUCTION_COUNTRY_PROPERTY_NAME = "name";

    private static List<MovieProductionCountry> productionCountriesFrom(JSONArray countriesJson) throws JSONException {
        List<MovieProductionCountry> countries = new ArrayList<>(countriesJson.length());
        for (int i = 0; i < countriesJson.length(); i++) {
            JSONObject countryJson = countriesJson.getJSONObject(i);
            countries.add(i, new MovieProductionCountry(
                countryJson.getString(MOVIE_PRODUCTION_COUNTRY_PROPERTY_COUNTRY_CODE),
                countryJson.getString(MOVIE_PRODUCTION_COUNTRY_PROPERTY_NAME)
            ));
        }
        return countries;
    }

    private static final String SPOKEN_LANGUAGE_PROPERTY_LANGUAGE_CODE = "iso_639_1";
    private static final String SPOKEN_LANGUAGE_PROPERTY_NAME = "name";

    private static List<SpokenLanguage> spokenLanguagesFrom(JSONArray languagesJson) throws JSONException {
        List<SpokenLanguage> languages = new ArrayList<>(languagesJson.length());
        for (int i = 0; i < languagesJson.length(); i++) {
            JSONObject languageJson = languagesJson.getJSONObject(i);
            languages.add(i, new SpokenLanguage(
                languageJson.getString(SPOKEN_LANGUAGE_PROPERTY_LANGUAGE_CODE),
                languageJson.getString(SPOKEN_LANGUAGE_PROPERTY_NAME)
            ));
        }
        return languages;
    }

    private static MovieDetail.Status movieStatusFrom(String statusString) {
        switch (statusString) {
            case "Rumored": return MovieDetail.Status.Rumored;
            case "Planned": return MovieDetail.Status.Planned;
            case "In Production": return MovieDetail.Status.InProduction;
            case "Post Production": return MovieDetail.Status.PostProduction;
            case "Canceled": return MovieDetail.Status.Canceled;
            case "Released":
            default: return MovieDetail.Status.Released;
        }
    }
}
