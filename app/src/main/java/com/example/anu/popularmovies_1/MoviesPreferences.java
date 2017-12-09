package com.example.anu.popularmovies_1;

/*
  Created by Design on 30-11-2017.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.anu.popularmovies_1.utils.MovieDBUtils;

/**
 * this class holds all user's preferences
 * and getter methods to get all user preferred values
 */
public class MoviesPreferences {

    private static final String DEFAULT_SORT_BY_VALUE = MovieDBUtils.PARAM_VALUE_POPULAR;

    /**
     * method to return default sort by value
     * @return by default, it will be {@literal MovieDBUtils.PARAM_VALUE_POPULAR}
     */
    public String getDefaultSortByValue(){
        return DEFAULT_SORT_BY_VALUE;
    }

    /**
     * method to return user preferred sort by preference
     * @param context
     * @return preferred sort by preference
     */
    public static String getUserPreferredSortByValue(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String preferenceKey = context.getResources().getString(R.string.pref_sortby_key);
        String defPreferenceValue = DEFAULT_SORT_BY_VALUE;
        return sharedPreferences.getString(preferenceKey, defPreferenceValue);
    }

}
