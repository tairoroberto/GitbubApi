package com.example.tairo.gitbubapi.presenter;

import com.example.tairo.gitbubapi.contract.RepositoryContract;
import com.example.tairo.gitbubapi.model.Repository;
import com.example.tairo.gitbubapi.model.RepositoryModel;
import com.example.tairo.gitbubapi.model.RepositoryResponse;

import java.util.List;

public class RepositoryPresenter implements RepositoryContract.Presenter {

    private RepositoryContract.View view;
    private RepositoryContract.Model model;

    @Override
    public void attachView(RepositoryContract.View view) {
        this.view = view;
        this.model = new RepositoryModel(this);
    }

    @Override
    public void detachView() {
        this.view = null;
        this.model = null;
    }

    @Override
    public void getAllRepositories() {
        view.showProgress(true);
        model.getRepositories(view.getContext());
    }

    @Override
    public void showRepositories(List<Repository> repositories) {
        view.showProgress(false);
        view.showRepositories(repositories);
    }

    @Override
    public void showRepositorytError(Throwable t) {
        view.showProgress(false);
        view.showRepositorytError(t);
    }
}
