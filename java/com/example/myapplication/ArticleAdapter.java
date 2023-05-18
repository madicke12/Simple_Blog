package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ArticleAdapter extends BaseAdapter {
    private List<Article> articles;
    private LayoutInflater inflater;

    public ArticleAdapter(Context context, List<Article> articles) {
        this.articles = articles;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return articles.size();
    }

    @Override
    public Object getItem(int position) {
        return articles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_article, parent, false);
        }

        TextView titleTextView = convertView.findViewById(R.id.Title);
        TextView descriptionTextView = convertView.findViewById(R.id.Description);

        Article article = articles.get(position);
        titleTextView.setText(article.getTitle());
        descriptionTextView.setText(article.getDescription());

        return convertView;
    }
}
