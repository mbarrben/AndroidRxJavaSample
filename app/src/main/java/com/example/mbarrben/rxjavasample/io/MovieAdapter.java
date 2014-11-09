package com.example.mbarrben.rxjavasample.io;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class MovieAdapter {

    public static final String ENDPOINT = "http://www.myapifilms.com";

    public MyApiFilmsService create() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(1, TimeUnit.MINUTES);
        client.setReadTimeout(2, TimeUnit.MINUTES);

        return new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .setClient(new OkClient(client))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(MyApiFilmsService.class);
    }
}
