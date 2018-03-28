package com.example.tairo.gitbubapi.model;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.tairo.gitbubapi.contract.RepositoryContract;
import com.example.tairo.gitbubapi.model.service.ApiService;
import com.example.tairo.gitbubapi.presenter.RepositoryPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryModel implements RepositoryContract.Model {
    private RepositoryContract.Presenter presenter;

    public RepositoryModel(RepositoryPresenter repositoryPresenter) {
        this.presenter = repositoryPresenter;
    }

    @Override
    public void getRepositories(Context context) {
        ApiService.getInstance(context).getRepositories().enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(@NonNull Call<List<Repository>> call, @NonNull Response<List<Repository>> response) {
                if (response.body() != null) {
                    presenter.showRepositories(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Repository>> call, @NonNull Throwable t) {
                presenter.showRepositorytError(t);
            }
        });
    }
}
