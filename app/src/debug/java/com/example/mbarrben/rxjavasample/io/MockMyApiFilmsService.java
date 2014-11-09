package com.example.mbarrben.rxjavasample.io;

import com.example.mbarrben.rxjavasample.model.Movie;

import java.util.List;

import retrofit.http.Query;
import rx.Observable;
import rx.Subscriber;

public class MockMyApiFilmsService implements MyApiFilmsService {

    @Override
    public Observable<List<Movie>> getMovies(@Query("title") String title) {
        return Observable.create((Subscriber<? super List<Movie>> subscriber) -> subscriber.onNext(MockMovies.LIST));
    }
}
