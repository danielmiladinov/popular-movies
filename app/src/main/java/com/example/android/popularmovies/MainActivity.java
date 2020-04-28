package com.example.android.popularmovies;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.popularmovies.model.Movie;
import com.example.android.popularmovies.model.PopularMoviesResponse;
import com.example.android.popularmovies.repository.movie.TheMovieDbDotOrg;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int popularMoviesResultsPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadMoviesData();
    }

    private void loadMoviesData() {
        // TODO show movies view
        String apiKey = getString(R.string.themoviedb_api_key_v3);
        new FetchPopularMoviesTask().execute(apiKey, popularMoviesResultsPage);
    }

    static class FetchPopularMoviesTask extends AsyncTask<Object, Void, List<Movie>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // TODO show loading indicator
        }

        @Override
        protected List<Movie> doInBackground(Object... objects) {
            if (objects.length > 0) {
                String apiKey = (String) objects[0];
                Integer page = (Integer) objects[1];

                try {
                    PopularMoviesResponse response = TheMovieDbDotOrg.getPopularMovies(apiKey, page);
                    return response.getResults();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            } else {
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<Movie> movies) {
            // TODO hide loading indicator
            // TODO handle movies or error
            super.onPostExecute(movies);
        }
    }
}
