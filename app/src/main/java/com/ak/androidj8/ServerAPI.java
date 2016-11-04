package com.ak.androidj8;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerAPI {

    public static <T> T createRetrofitService(Class<T> classTarget) {
        return new Retrofit.Builder()
                .baseUrl("https://phalt-pokeapi.p.mashape.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build().create(classTarget);
    }

}
