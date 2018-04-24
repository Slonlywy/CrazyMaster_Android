package com.example.yunwen.master_fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.yunwen.master_fragment.fragment.NewsContentFragment;

public class EasyNewsFragmentActivity extends AppCompatActivity {

    public static void startAction(Context context, String news_title, String news_content){
        Intent intent = new Intent(context, EasyNewsFragmentActivity.class);
        intent.putExtra("news_title",news_title);
        intent.putExtra("news_content",news_title);
        context.startActivity(intent);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);

        String news_title = getIntent().getStringExtra("news_title");
        String news_content = getIntent().getStringExtra("news_content");
        NewsContentFragment fragment = (NewsContentFragment) getSupportFragmentManager()
                .findFragmentById(R.id.news_content_fragment);
        fragment.refresh(news_title,news_content);
    }
}
