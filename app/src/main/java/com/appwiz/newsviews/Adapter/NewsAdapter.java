package com.appwiz.newsviews.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appwiz.newsviews.Activity.NewsDetailsActivity;
import com.appwiz.newsviews.R;
import com.appwiz.newsviews.model.HeadLine;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private final Activity activity;
    private HeadLine newsList = new HeadLine();
    private AlertDialog.Builder builder;


    public NewsAdapter(Activity activity, AlertDialog.Builder builder) {
        this.activity = activity;
        this.builder = builder;

    }

    public NewsAdapter(Activity activity) {
        this.activity = activity;
    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_list_item, viewGroup, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        RequestOptions options = new RequestOptions().centerCrop().placeholder(R.drawable.loading).error(R.drawable.loading)
                                    .diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.HIGH);
        Glide.with(activity).load(newsList.getArticles().get(position).getUrlToImage())
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(options)
                .into(holder.newsImage);


        holder.title.setText(newsList.getArticles().get(position).getTitle());
        holder.author.setText("Author: " + newsList.getArticles().get(position).getAuthor());
        holder.source.setText("Source: " + newsList.getArticles().get(position).getSource().getName());
    }

    @Override
    public int getItemCount() {
        return newsList.getArticles().size();
    }

    public void setItem(HeadLine newsList) {
        this.newsList = newsList;
        notifyDataSetChanged();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        private final ImageView newsImage;
        private final TextView title;
        private final TextView author;
        private final TextView source;

        private NewsViewHolder(View itemView) {
            super(itemView);
            newsImage = itemView.findViewById(R.id.news_item_image);
            title = itemView.findViewById(R.id.news_item_title);
            author = itemView.findViewById(R.id.news_item_author);
            source = itemView.findViewById(R.id.news_item_source);

            // WEBVIEW CONTROL
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    builder.setMessage("Open this link with which Browser?")
                            .setPositiveButton("Default", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(Intent.ACTION_VIEW);
                                    i.setData(Uri.parse(newsList.getArticles().get(getAdapterPosition()).getUrl()));
                                    activity.startActivity(i);
                                }
                            }).setNegativeButton("In App", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            activity.startActivity(new Intent(activity,NewsDetailsActivity.class)
                            .putExtra("News Link",newsList.getArticles().get(getAdapterPosition()).getUrl()));
                        }
                    }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            });
        }
    }

}
