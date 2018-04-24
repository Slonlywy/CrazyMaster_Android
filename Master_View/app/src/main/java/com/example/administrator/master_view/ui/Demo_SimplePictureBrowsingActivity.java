package com.example.administrator.master_view.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.master_view.R;
import com.example.administrator.master_view.constant.Config;

/**
 * 简单的图片浏览
 * 疯狂讲义第二章 P46
 * create by 黄伟嘉 on 2017/12/18
 */
public class Demo_SimplePictureBrowsingActivity extends AppCompatActivity {

    private LinearLayout mLl_simplePictureBrowsing;
    private ImageView mImageView;
    //当前显示的image
    private int currentImage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_picture_browsing);

        initView();
    }

    private void initView() {
        mLl_simplePictureBrowsing = (LinearLayout) findViewById(R.id.ll_SimplePictureBrowsing);
        //动态创建ImageView组件,存放图片
        mImageView = new ImageView(this);

        //动态添加控件到容器中
        mLl_simplePictureBrowsing.addView(mImageView);

        //设置图片资源
        mImageView.setImageResource(Config.imageResources[0]);

        //控件的点击事件
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //可能出现图片过大，导致OOM 这里暂时不考虑，详细参考图片处理
                mImageView.setImageResource(Config.imageResources[++currentImage % Config.imageResources.length]);
            }
        });

    }
}
