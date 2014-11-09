package com.example.mbarrben.rxjavasample.model;

public class Movie {
    private String title;
    private String urlPoster;
    private String year;
    private String rating;

    public Movie(String title, String urlPoster, String year, String rating) {
        this.title = title;
        this.urlPoster = urlPoster;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getUrlPoster() {
        return urlPoster;
    }

    public String getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }
}
