package com.example.nasatest;

import android.app.Application;

import com.example.nasatest.network.NasaApi;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class NasaApp extends Application {
    private static NasaApi nasaApi;
    private Retrofit retrofit;
    private final String BASE_URL = "https://api.nasa.gov";

    @Override
    public void onCreate() {
        super.onCreate();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
        nasaApi = retrofit.create(NasaApi.class);
    }

    public static NasaApi getApi(){
        return nasaApi;
    }
}
