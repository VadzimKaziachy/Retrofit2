package com.example.vadzim.internet;

import android.app.Application;

import com.example.vadzim.internet.api.UmoriliApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by misha on 31.10.2016.
 */

public class App extends Application {

    private static UmoriliApi umoriliApi;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        umoriliApi = retrofit.create(UmoriliApi.class);
    }

    public static UmoriliApi getApi() {
        return umoriliApi;
    }
}
