package com.codepath.nytimessearch;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ArticleArrayAdapetr extends ArrayAdapter<Article> {
    public ArticleArrayAdapetr(Context context, List<Article>articles) {
        super(context, android.R.layout.simple_list_item_1, articles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Article article= this.getItem(position);

        if(convertView==null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.item_article_result,parent, false);
        }

        ImageView imageView= (ImageView) convertView.findViewById(R.id.ivImage);

        imageView.setImageResource(0);

        TextView tvTitle= (TextView) convertView.findViewById(R.id.tvTitle);
        tvTitle.setText(article.getHeadLine());

        String thumbNail= article.getThumbNail();
        if(!TextUtils.isEmpty(thumbNail)){
            Picasso.with(getContext()).load(thumbNail).into(imageView);
        }
        return convertView;

    }
}
