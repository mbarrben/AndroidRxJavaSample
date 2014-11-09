package com.example.mbarrben.rxjavasample.io;

import com.example.mbarrben.rxjavasample.model.Movie;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface MyApiFilmsService {
    @GET("/imdb?limit=10")
    Observable<List<Movie>> getMovies(@Query("title") String title);
}
