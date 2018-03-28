package com.example.tairo.gitbubapi.contract;


import android.content.Context;

import com.example.tairo.gitbubapi.model.Repository;
import com.example.tairo.gitbubapi.model.RepositoryResponse;

import java.util.List;

public class RepositoryContract {
    public interface Model {

        void getRepositories(Context context);
    }

    public interface View {
        Context getContext();

        void showRepositories(List<Repository> response);

        void showRepositorytError(Throwable t);

        void showProgress(Boolean show);
    }

    public interface Presenter {
        void attachView(View view);

        void detachView();

        void getAllRepositories();

        void showRepositories(List<Repository> repositories);

        void showRepositorytError(Throwable t);
    }
}
