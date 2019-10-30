package com.example.tairo.gitbubapi.presenter;

import com.example.tairo.gitbubapi.contract.UserContract;
import com.example.tairo.gitbubapi.model.User;
import com.example.tairo.gitbubapi.model.UserModel;

import java.util.List;

public class UserPresenter implements UserContract.Presenter {

    private UserContract.View view;
    private UserContract.Model model;

    @Override
    public void init(UserContract.View view) {
        this.view = view;
        this.model = new UserModel(this);
    }

    @Override
    public void destroy() {
        this.view = null;
        this.model.destroy();
        this.model = null;
    }

    @Override
    public void getAllUsers() {
        view.showProgress(true);
        model.getRepositories(view.getContext());
    }

    @Override
    public void showUsers(List<User> repositories) {
        view.showProgress(false);
        view.showUsers(repositories);
    }

    @Override
    public void showUserError(Throwable t) {
        view.showProgress(false);
        view.showUserError(t);
    }
}
