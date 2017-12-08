package com.example.anu.popularmovies_1.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

import com.example.anu.popularmovies_1.model.Movie;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Design on 27-11-2017.
 */

public class NetworkUtils {

    /**
     * method to check network is available or not
     * @param context
     * @return true if network is available, otherwise return false
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     * method to build the url from the sort category and api key
     * @param sortCategory
     * @return
     * @throws MalformedURLException
     */
    public static URL buildUrl(String sortCategory) throws MalformedURLException {

        //append user preferred sort category to base url
        String baseUrl = MovieDBUtils.BASE_URL + MovieDBUtils.KEY_MOVIE + "/" + sortCategory;

        Uri uri = Uri.parse(baseUrl).buildUpon()
                .appendQueryParameter(MovieDBUtils.PARAM_API_KEY, MovieDBUtils.API_KEY)
                .build();
        URL url = new URL(uri.toString());
        return url;
    }

    /**
     * method to get response from provided Http url
     * @param url the url to get response from
     * @return response from provided url
     * @throws IOException
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        try {
           InputStream inputStream = httpURLConnection.getInputStream();
           Scanner scanner = new Scanner(inputStream);
           scanner.useDelimiter("\\A");
           if (scanner.hasNext()){
               return scanner.next();
           }
           else {
               return null;
           }
       }
       finally {
           httpURLConnection.disconnect();
       }
    }


}
