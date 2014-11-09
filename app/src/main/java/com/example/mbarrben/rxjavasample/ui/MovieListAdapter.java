package com.example.mbarrben.rxjavasample.ui;

import com.example.mbarrben.rxjavasample.R;
import com.example.mbarrben.rxjavasample.model.Movie;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MovieListAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final List<Movie> movies;

    public MovieListAdapter(Context context, List<Movie> movies) {
        this.movies = movies;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Movie getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;

        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.movie_item, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        Movie movie = getItem(position);
        holder.title.setText(movie.getTitle());
        holder.year.setText(movie.getYear());
        holder.rating.setText(movie.getRating());

        if (!TextUtils.isEmpty(movie.getUrlPoster())) {
            Picasso.with(view.getContext())
                    .load(movie.getUrlPoster())
                    .into(holder.image);
        }

        return view;
    }

    static class ViewHolder {
        @InjectView(R.id.image)
        ImageView image;
        @InjectView(R.id.title)
        TextView title;
        @InjectView(R.id.year)
        TextView year;
        @InjectView(R.id.rating)
        TextView rating;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
