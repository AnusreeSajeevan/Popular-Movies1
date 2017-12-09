package com.example.anu.popularmovies_1.utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Design on 30-11-2017.
 */

public class MoviesJsonUtils {
    private static final String TAG = MoviesJsonUtils.class.getSimpleName();

    /**
     * method to get JSONObject from network response
     * @param response
     * @return json object
     * @throws JSONException
     */
    public static JSONObject getJSONObjectFromResponse(String response) throws JSONException {
        return new JSONObject(response);
    }

}
