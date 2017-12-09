package com.example.anu.popularmovies_1.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.anu.popularmovies_1.R;
import com.example.anu.popularmovies_1.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Design on 27-11-2017.
 *
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieHolder> {

    private List<Movie> movieList;
    private Context context;
    private OnClickHandleListener clickHandleListener;
    private static final String TAG = MovieAdapter.class.getSimpleName();
    private static int lastAnimatedPosition = -1;

    public MovieAdapter(Context context, List<Movie> movieList, OnClickHandleListener clickHandleListener) {
        this.context = context;
        this.movieList = movieList;
        this.clickHandleListener = clickHandleListener;
    }

    public interface OnClickHandleListener {
        void onThumbnailClick(int pos);
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_movie_item, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(final MovieHolder holder, final int position) {
        Movie movie = movieList.get(position);
        holder.txtMovieName.setText(movie.getTitle());
        holder.txtRating.setText(String.valueOf(movie.getVoteAverage()));
        Picasso.with(context)
                .load(movie.getPosterPath()).fit()
                .placeholder(R.drawable.ic_place_holder)
                .error(R.drawable.ic_place_holder)
                .into(holder.imgThumbnail);

        holder.imgThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickHandleListener.onThumbnailClick(position);
            }
        });
        
        setEnterAnimation(holder.cardView, position);
    }

    /**
     * method to set enter animation to each recyclerview item
     * if that item is not already added
     * @param cardView item on which animation is to be set
     * @param position item position
     */
    private void setEnterAnimation(CardView cardView, int position) {

        if(position > lastAnimatedPosition){
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.enter_anim);
            cardView.setAnimation(animation);
            lastAnimatedPosition = position;
        }

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
