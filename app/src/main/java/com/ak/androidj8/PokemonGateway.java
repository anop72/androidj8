package com.ak.androidj8;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import rx.Observable;

public interface PokemonGateway {

    @Headers({
            "X-Mashape-Key: {YOUR-KEY}",
            "Accept: application/json"
        })
    @GET("/pokemon/{id}/")
    Observable<Pokemon> pokemon(@Path("id") int id);
}
