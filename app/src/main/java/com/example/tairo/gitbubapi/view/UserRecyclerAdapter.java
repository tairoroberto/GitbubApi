package com.example.tairo.gitbubapi.view;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.tairo.gitbubapi.R;
import com.example.tairo.gitbubapi.model.User;

import java.util.List;

import static com.example.tairo.gitbubapi.utils.ImageUtil.loadImage;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.ViewHolder> {

    private List<User> users;

    public UserRecyclerAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = users.get(position);
        holder.bind(user);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(user.getHtmlUrl()));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
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

        void bind(User user) {
            loadImage(user.getOwner().getAvatarUrl(), imageView, progressBar);
            textViewName.setText(user.getName());
            textViewLink.setText(user.getHtmlUrl());
            textViewDescription.setText(user.getDescription());
        }
    }

    public void update(List<User> users) {
        this.users.clear();
        this.users.addAll(users);
        notifyDataSetChanged();
    }
}
