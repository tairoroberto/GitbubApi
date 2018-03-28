package com.example.tairo.gitbubapi.view;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.tairo.gitbubapi.R;
import com.example.tairo.gitbubapi.model.Repository;

import java.util.List;

import static com.example.tairo.gitbubapi.utils.ImageUtil.loadImage;

public class RepositoryRecyclerAdapter extends RecyclerView.Adapter<RepositoryRecyclerAdapter.ViewHolder> {

    private List<Repository> repositories;

    public RepositoryRecyclerAdapter(List<Repository> repositories) {
        this.repositories = repositories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Repository repository = repositories.get(position);
        holder.bind(repository);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(repository.getHtmlUrl()));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textViewName;
        private TextView textViewLink;
        private TextView textViewDescription;
        private ProgressBar progressBar;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            progressBar = itemView.findViewById(R.id.progressBar);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewLink = itemView.findViewById(R.id.textViewLink);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
        }

        void bind(Repository repository) {
            loadImage(repository.getOwner().getAvatarUrl(), imageView, progressBar);
            textViewName.setText(repository.getName());
            textViewLink.setText(repository.getHtmlUrl());
            textViewDescription.setText(repository.getDescription());
        }
    }

    public void update(List<Repository> repositories) {
        this.repositories.clear();
        this.repositories.addAll(repositories);
        notifyDataSetChanged();
    }
}
