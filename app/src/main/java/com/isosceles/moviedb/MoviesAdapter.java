
package com.isosceles.moviedb;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import com.isosceles.moviedb.Movie;
import com.isosceles.moviedb.R;


/**
 * Created by Teletran on 7/15/2016.
 */


public class MoviesAdapter extends ArrayAdapter<Movie> {


    public MoviesAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    // Model => View
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Movie movies = getItem(position);

        // Define ViewHolder
        ViewHolder holder = null;

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
            // Instantiate View Holder / pass convertView to ViewHolder to init.
            holder = new ViewHolder(convertView);
            // Store holder so you don't create it again while recycling
            convertView.setTag(holder);
           //Log.d("DEBUG ", "CREATING A NEW ROW ");
        } // Recycling
        else {
            holder = (ViewHolder) convertView.getTag();
           //Log.d("DEBUG ", "RECYCLING ");
        }

        // Populate the data into the template view using the data object
        holder.mTitle.setText(movies.getmTitle());
        holder.mOverView.setText(movies.getmOverView());
        Picasso.with(getContext()).load(movies.getmPosterURL()).into(holder.mImage);


        return convertView;

       /*

        ** DEPRECATED. v0.0 code **
         * --------------------- *

        // Find image view
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivPoster);
        // Clear out image from convertView
        ivImage.setImageResource(0);

        // Lookup view for data population
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverView = (TextView) convertView.findViewById(R.id.tvOverView);
        // Populate the data into the template view using the data object
        tvTitle.setText(movies.getmTitle());
        tvOverView.setText(movies.getmOverView());
        Picasso.with(getContext()).load(movies.getmPosterURL()).into(ivImage);
*/
        // Return the completed view to render on screen
    }
}

