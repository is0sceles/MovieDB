package com.isosceles.moviedb;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Teletran on 7/22/2016.
 */
public class ViewHolder {

    ImageView mImage;
    TextView mTitle;
    TextView mOverView;

    // Lookup view for data population
    ViewHolder(View v) {
        mImage = (ImageView) v.findViewById(R.id.ivPoster);
        mTitle = (TextView) v.findViewById(R.id.tvTitle);
        mOverView = (TextView) v.findViewById(R.id.tvOverView);

    }

}
