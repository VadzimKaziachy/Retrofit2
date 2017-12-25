package com.example.vadzim.internet;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vadzim.internet.dto.Article;

import java.util.List;

/**
 * Created by Vadzim on 24.12.2017.
 */

public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView_Adapter.ViewHolder> {

    private List<Article> posts;

    void setPosts(List<Article> posts) {
        this.posts = posts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Article post = posts.get(position);

        if (post != null && holder != null) {
            holder.bind(post);
        }
    }

    @Override
    public int getItemCount() {
        if (posts == null) return 0;
        return posts.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView post;
        TextView site;

        ViewHolder(View itemView) {
            super(itemView);
            post = itemView.findViewById(R.id.postitem_post);
            site = itemView.findViewById(R.id.postitem_site);
        }

        void bind(Article posts) {
            post.setText(posts.getTitle());
            site.setText(posts.getAuthor());
        }
    }
}
