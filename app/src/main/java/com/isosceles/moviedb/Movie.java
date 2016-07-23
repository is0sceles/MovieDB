
package com.isosceles.moviedb;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;


/**
 * Model, attributes for our objects on 7/15/2016.
 */

public class Movie {

    // Getters
    public String getmOverView() {
        return mOverView;
    }

    public String getmPosterURL() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", mPosterURL);
    }

    public String getmTitle() {
        return mTitle;
    }

    // Class variables
    public String mTitle;
    public String mPosterURL;
    public String mOverView;

    public Movie(JSONObject jsonObject) throws JSONException {
        this.mTitle = jsonObject.getString("original_title");
        this.mPosterURL = jsonObject.getString("poster_path");
        this.mOverView = jsonObject.getString("overview");
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array) {
        ArrayList<Movie> results = new ArrayList<>();

        for (int x = 0; x < array.length(); x++){
            try {
                results.add(new Movie(array.getJSONObject(x)));
            } catch ( JSONException e ){
                e.printStackTrace();
            }
        }
        return results;
    }
}

