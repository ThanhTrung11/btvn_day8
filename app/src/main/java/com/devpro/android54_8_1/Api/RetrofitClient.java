package com.devpro.android54_8_1.Api;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static final String BASE_URL = "https://dummyjson.com/";
    private static Retrofit instances;
    public static Retrofit getInstances(){
        if(instances==null){
            instances = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instances;
    }
}
