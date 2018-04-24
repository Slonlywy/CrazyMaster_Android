package com.example.yunwen.master_fragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yunwen.master_fragment.R;

/**
 * Created by yunwen on 2018/1/29.
 */

public class NewsContentFragment extends Fragment {

    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.news_content_frag, container, false);
        return mView;
    }


    public void refresh(String title,String content){
        LinearLayout LLLayout = (LinearLayout) mView.findViewById(R.id.ll_layout);
        LLLayout.setVisibility(View.VISIBLE);
        TextView news_title = (TextView) mView.findViewById(R.id.news_title);
        TextView news_content = (TextView) mView.findViewById(R.id.news_content);
        news_title.setText(title);
        news_content.setText(content);
    }
}
