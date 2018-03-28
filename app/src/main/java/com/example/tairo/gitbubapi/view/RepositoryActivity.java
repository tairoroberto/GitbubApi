package com.example.tairo.gitbubapi.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.tairo.gitbubapi.R;
import com.example.tairo.gitbubapi.contract.RepositoryContract;
import com.example.tairo.gitbubapi.model.Repository;
import com.example.tairo.gitbubapi.presenter.RepositoryPresenter;

import java.util.ArrayList;
import java.util.List;

public class RepositoryActivity extends AppCompatActivity implements RepositoryContract.View {

    private RepositoryRecyclerAdapter adapter;
    private List<Repository> repositories = new ArrayList<>();
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar progress;
    private TextView textViewNotFound;
    private RepositoryContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new RepositoryPresenter();
        presenter.attachView(this);

        initViews();
        setRecyclerView();
        getAllRepositories();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        progress = findViewById(R.id.progress);
        textViewNotFound = findViewById(R.id.textViewNotFound);
    }

    private void setRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RepositoryRecyclerAdapter(repositories);
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(this::getAllRepositories);
    }

    private void getAllRepositories() {
        presenter.getAllRepositories();
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
    public void showRepositories(List<Repository> repositories) {
        if (!repositories.isEmpty()) {
            adapter.update(repositories);
            textViewNotFound.setVisibility(View.GONE);
        } else {
            textViewNotFound.setVisibility(View.VISIBLE);
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showRepositorytError(Throwable t) {
        textViewNotFound.setVisibility(View.VISIBLE);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
