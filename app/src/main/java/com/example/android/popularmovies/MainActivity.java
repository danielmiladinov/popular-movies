package com.example.android.popularmovies;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.popularmovies.model.Movie;
import com.example.android.popularmovies.model.PagedMoviesResponse;
import com.example.android.popularmovies.repository.movie.TheMovieDbDotOrg;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    enum MoviesType { POPULAR, TOP_RATED }

    private static final int numberOfColumns = 2;
    private static final float HEIGHT_TO_WIDTH = 1.5f;

    private RecyclerView moviePosters;
    private EndlessRecyclerViewScrollListener scrollListener;
    private MovieAdapter movieAdapter;
    private TextView errorMessageDisplay;
    private ProgressBar loadingIndicator;
    private MoviesType moviesType = MoviesType.POPULAR;
    private int popularMoviesResultsPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int imageWidth = displayMetrics.widthPixels / numberOfColumns;
        int imageHeight = Math.round(imageWidth * HEIGHT_TO_WIDTH);

        GridLayoutManager twoColumnGrid = new GridLayoutManager(
            MainActivity.this,
            numberOfColumns
        );

        scrollListener = new EndlessRecyclerViewScrollListener(twoColumnGrid) {
            @Override
            void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                popularMoviesResultsPage = page;
                loadMoviesData();
            }
        };

        movieAdapter = new MovieAdapter(imageHeight, imageWidth);

        moviePosters = findViewById(R.id.rv_movie_posters);
        moviePosters.setLayoutManager(twoColumnGrid);
        moviePosters.setHasFixedSize(true);
        moviePosters.setAdapter(movieAdapter);
        moviePosters.addOnScrollListener(scrollListener);

        errorMessageDisplay = findViewById(R.id.tv_error_message_display);

        loadingIndicator = findViewById(R.id.pb_loading_indicator);

        loadMoviesData();
    }

    private void loadMoviesData() {
        showMoviesDataView();
        String apiKey = getString(R.string.themoviedb_api_key_v3);
        new FetchPopularMoviesTask(this).execute(apiKey, popularMoviesResultsPage);
    }

    private void refresh() {
        popularMoviesResultsPage = 1;
        scrollListener.resetState();
        movieAdapter.resetState();
        loadMoviesData();
    }

    private void showMoviesDataView() {
        errorMessageDisplay.setVisibility(View.INVISIBLE);
        moviePosters.setVisibility(View.VISIBLE);
    }

    private void showErrorMessage() {
        errorMessageDisplay.setVisibility(View.VISIBLE);
        moviePosters.setVisibility(View.INVISIBLE);
    }

    static class FetchPopularMoviesTask extends AsyncTask<Object, Void, List<Movie>> {
        private WeakReference<MainActivity> weakActivity;

        FetchPopularMoviesTask(MainActivity launcher) {
            super();
            weakActivity = new WeakReference<>(launcher);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            MainActivity ma = weakActivity.get();

            if (ma != null) {
                ma.loadingIndicator.setVisibility(View.VISIBLE);
            }
        }

        @Override
        protected List<Movie> doInBackground(Object... objects) {
            MainActivity ma = weakActivity.get();

            if (ma != null) {
                if (objects.length > 0) {
                    String apiKey = (String) objects[0];
                    Integer page = (Integer) objects[1];

                    try {
                        PagedMoviesResponse response;

                        if (ma.moviesType == MoviesType.TOP_RATED) {
                            response = TheMovieDbDotOrg.getTopRatedMovies(apiKey, page);
                        } else {
                            response = TheMovieDbDotOrg.getPopularMovies(apiKey, page);
                        }

                        return response != null ? response.getResults() : new ArrayList<Movie>();
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<Movie> movies) {
            MainActivity ma = weakActivity.get();

            if (ma != null) {
                ma.loadingIndicator.setVisibility(View.INVISIBLE);
                if (movies != null) {
                    ma.showMoviesDataView();

                    if (movies.size() > 0) {
                        ma.movieAdapter.addMovies(movies);
                    }
                } else {
                    ma.showErrorMessage();
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_popular:
                moviesType = MoviesType.POPULAR;
                setTitle(getString(R.string.main_activity_title_popular_movies));
                refresh();
                return true;

            case R.id.action_top_rated:
                moviesType = MoviesType.TOP_RATED;
                setTitle(getString(R.string.main_activity_title_top_rated_movies));
                refresh();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
