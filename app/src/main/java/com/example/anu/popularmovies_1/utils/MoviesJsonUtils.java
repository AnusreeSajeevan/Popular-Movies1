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
     * @param response the response to get jasonobject from
     * @return json object
     * @throws JSONException exception
     */
    public static JSONObject getJSONObjectFromResponse(String response) throws JSONException {
        return new JSONObject(response);
    }

}
