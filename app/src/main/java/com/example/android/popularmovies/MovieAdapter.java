package com.example.android.popularmovies;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.popularmovies.model.Movie;
import com.example.android.popularmovies.utils.MovieUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<Movie> movies;
    private final int imageHeight;
    private final int imageWidth;

    MovieAdapter(int imageHeight, int imageWidth) {
        this.imageHeight = imageHeight;
        this.imageWidth = imageWidth;
    }

    void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
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
        Movie m = movies == null ? null : movies.get(position);
        holder.setMovie(m);
    }

    @Override
    public int getItemCount() {
        return movies == null ? 0 : movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView moviePoster;

        ViewHolder(@NonNull ImageView itemView) {
            super(itemView);
            moviePoster = itemView;
        }

        void setMovie(Movie m) {
            String posterPath = MovieUtils.absolutePosterImagePathOf(m);
            Picasso p = Picasso.get();
            p.setIndicatorsEnabled(true);
            p.setLoggingEnabled(true);
            p.load(posterPath).resize(imageWidth, imageHeight).into(moviePoster);
            moviePoster.setContentDescription(m.getTitle());
        }
    }
}
