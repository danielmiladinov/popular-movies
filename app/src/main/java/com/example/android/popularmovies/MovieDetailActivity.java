package com.example.android.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.popularmovies.model.MovieDetail;
import com.example.android.popularmovies.utils.MovieUtils;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class MovieDetailActivity extends AppCompatActivity {
    public static final String MOVIE_DETAIL = "MOVIE_DETAIL";

    private static final int imageHeight = 225;
    private static final int imageWidth = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        boolean errorDetected = false;

        if (intent.hasExtra(MOVIE_DETAIL)) {
            MovieDetail m = intent.getParcelableExtra(MOVIE_DETAIL);
            if (m != null) {
                setTitle(getString(R.string.movie_detail));
                setContentView(R.layout.activity_movie_detail);
                TextView movieTitle = findViewById(R.id.tv_movie_title_detail);
                movieTitle.setText(m.getTitle());

                ImageView moviePoster = findViewById(R.id.iv_movie_poster);
                Picasso p = Picasso.get();
                p.setIndicatorsEnabled(true);
                p.setLoggingEnabled(true);

                RequestCreator picassoRequest;

                if (!m.getPosterPath().equals("null")) {
                    String posterPath = MovieUtils.absolutePosterImagePathOf(m, imageWidth);
                    picassoRequest = p.load(posterPath);
                } else {
                    picassoRequest = p.load(R.drawable.no_poster_available);
                }

                picassoRequest.resize(imageWidth, imageHeight).into(moviePoster);
                moviePoster.setContentDescription(m.getTitle());

                TextView movieYear = findViewById(R.id.tv_movie_year);
                movieYear.setText(m.getReleaseDate().substring(0, 4));

                TextView runtime = findViewById(R.id.tv_runtime);
                runtime.setText(String.format("%smin", m.getRuntime()));

                TextView rating = findViewById(R.id.tv_rating);
                rating.setText(String.format("%2.1f/10", m.getVoteAverage()));

                TextView overview = findViewById(R.id.tv_overview);
                overview.setText(m.getOverview());
            } else {
                errorDetected = true;
            }
        } else {
            errorDetected = true;
        }

        if (errorDetected) {
            setTitle(getString(R.string.error_loading_movie_detail));
            setContentView(R.layout.movie_detail_error);
        }
    }
}
