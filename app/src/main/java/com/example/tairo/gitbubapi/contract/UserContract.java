package com.example.tairo.gitbubapi.contract;


import android.content.Context;

import com.example.tairo.gitbubapi.model.User;

import java.util.List;

public class UserContract {
    public interface Model {

        void getRepositories(Context context);
        void destroy();
    }

    public interface View {
        Context getContext();

        void showUsers(List<User> response);

        void showUserError(Throwable t);

        void showProgress(Boolean show);
    }

    public interface Presenter {
        void init(View view);

        void destroy();

        void getAllUsers();

        void showUsers(List<User> repositories);

        void showUserError(Throwable t);
    }
}
