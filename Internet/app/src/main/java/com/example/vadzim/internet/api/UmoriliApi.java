package com.example.vadzim.internet.api;

import com.example.vadzim.internet.dto.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by misha on 31.10.2016.
 */
public interface UmoriliApi {

    String SOURCES = "abc-news";
    String API_KEY = "b60d82179a3d46cca0776e64396e8947";

    @GET("top-headlines")
    Call<Example> getData(@Query("sources") String sources, @Query("apiKey") String apiKey);
}
