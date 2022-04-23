package com.example.nasatest.network;

import com.example.nasatest.model.NasaPhoto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NasaApi {
    @GET("/planetary/apod")
    Call<NasaPhoto> getPhoto(@Query("api_key") String apiKey);
}
