package com.example.tairo.gitbubapi.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.tairo.gitbubapi.R;
import com.example.tairo.gitbubapi.contract.UserContract;
import com.example.tairo.gitbubapi.model.User;
import com.example.tairo.gitbubapi.presenter.UserPresenter;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity implements UserContract.View {

    private UserRecyclerAdapter adapter;
    private List<User> users = new ArrayList<>();
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar progress;
    private TextView textViewNotFound;
    private UserContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new UserPresenter();
        presenter.init(this);

        initViews();
        setRecyclerView();

        presenter.getAllUsers();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        progress = findViewById(R.id.progress);
        textViewNotFound = findViewById(R.id.textViewNotFound);
    }

    private void setRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);
        adapter = new UserRecyclerAdapter(users);
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(() -> presenter.getAllUsers());
    }

    @Override
    public void showProgress(Boolean show) {
        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        recyclerView.setVisibility((show) ? View.GONE : View.VISIBLE);

        recyclerView.animate()
                .setDuration(shortAnimTime)
                .alpha((show) ? 0 : 1)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        recyclerView.setVisibility((show) ? View.GONE : View.VISIBLE);
                    }
                });

        progress.setVisibility((show) ? View.VISIBLE : View.GONE);
        progress.animate()
                .setDuration(shortAnimTime)
                .alpha((show) ? 1 : 0)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        progress.setVisibility((show) ? View.VISIBLE : View.GONE);
                    }
                });
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showUsers(List<User> users) {
        if (!users.isEmpty()) {
            adapter.update(users);
            textViewNotFound.setVisibility(View.GONE);
        } else {
            textViewNotFound.setVisibility(View.VISIBLE);
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showUserError(Throwable t) {
        textViewNotFound.setVisibility(View.VISIBLE);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }
}
