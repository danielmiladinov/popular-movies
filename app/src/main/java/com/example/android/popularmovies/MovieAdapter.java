package com.example.android.popularmovies;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.popularmovies.model.MovieSummary;
import com.example.android.popularmovies.utils.MovieUtils;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<MovieSummary> movies = new ArrayList<>(20);
    private OnMovieClickHandler movieClickHandler;
    private final int imageHeight;
    private final int imageWidth;

    MovieAdapter(OnMovieClickHandler movieClickHandler, int imageHeight, int imageWidth) {
        this.movieClickHandler = movieClickHandler;
        this.imageHeight = imageHeight;
        this.imageWidth = imageWidth;
        setHasStableIds(true);
    }

    void resetState() {
        movies = new ArrayList<>(20);
        notifyDataSetChanged();
    }

    void addMovies(List<MovieSummary> newMovies) {
        int positionStart = movies.size() - 1;
        int itemCount = newMovies.size();

        this.movies.addAll(newMovies);
        notifyItemRangeInserted(positionStart, itemCount);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(imageWidth, imageHeight);
        imageView.setLayoutParams(params);
        return new MovieAdapter.ViewHolder(imageView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MovieSummary m = movies == null ? null : movies.get(position);
        holder.setMovie(m);
    }

    @Override
    public int getItemCount() {
        return movies == null ? 0 : movies.size();
    }

    @Override
    public long getItemId(int position) {
        return movies.get(position).getId();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView moviePoster;

        ViewHolder(@NonNull ImageView itemView) {
            super(itemView);
            moviePoster = itemView;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            MovieSummary m = movies == null ? null : movies.get(getAdapterPosition());
            movieClickHandler.onMovieClick(m);
        }

        void setMovie(MovieSummary m) {
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
        }
    }

    interface OnMovieClickHandler {
        void onMovieClick(MovieSummary m);
    }
}
