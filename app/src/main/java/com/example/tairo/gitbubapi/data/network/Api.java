package com.example.tairo.gitbubapi.data.network;

import com.example.tairo.gitbubapi.BuildConfig;
import com.example.tairo.gitbubapi.model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface Api {
    @GET("/repositories")
    @Headers({"Accept:application/vnd.github.v3+json",
            "Authorization:" + BuildConfig.TOKEN_1 + BuildConfig.TOKEN_2})
    Observable<List<User>> getRepositories();
}
