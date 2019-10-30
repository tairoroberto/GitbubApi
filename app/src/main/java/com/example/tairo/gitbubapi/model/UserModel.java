package com.example.tairo.gitbubapi.model;

import android.content.Context;

import com.example.tairo.gitbubapi.contract.UserContract;
import com.example.tairo.gitbubapi.data.network.ApiService;
import com.example.tairo.gitbubapi.presenter.UserPresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class UserModel implements UserContract.Model {
    private UserContract.Presenter presenter;
    private CompositeDisposable disposable;

    public UserModel(UserPresenter userPresenter) {
        this.presenter = userPresenter;
        this.disposable = new CompositeDisposable();
    }

    @Override
    public void getRepositories(Context context) {
        disposable.add(ApiService.getInstance(context).getRepositories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> {
                    presenter.showUsers(users);
                }, throwable -> {
                    presenter.showUserError(throwable);
                }));
    }

    @Override
    public void destroy() {
        disposable.dispose();
    }
}
