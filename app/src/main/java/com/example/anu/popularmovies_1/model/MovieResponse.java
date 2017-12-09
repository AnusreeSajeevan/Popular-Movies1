package com.example.anu.popularmovies_1.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Design on 30-11-2017.
 *
 */

public class MovieResponse {

    private int pages;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("results")
    private List<Movie> results;

    public List<Movie> getResults() {
        return results;
    }

}
