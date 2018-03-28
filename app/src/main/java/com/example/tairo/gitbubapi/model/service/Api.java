package com.example.tairo.gitbubapi.model.service;

import com.example.tairo.gitbubapi.BuildConfig;
import com.example.tairo.gitbubapi.model.Repository;
import com.example.tairo.gitbubapi.model.RepositoryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface Api {
    @GET("/repositories")
    @Headers({"Accept:application/vnd.github.v3+json",
            "Authorization:" + BuildConfig.TOKEN_1 + BuildConfig.TOKEN_2})
    Call<List<Repository>> getRepositories();
}
