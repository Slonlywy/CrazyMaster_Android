package com.example.administrator.master_view.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.master_view.R;

public class Demo_AnimationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_animation);



    }

    /**
     * 普通View动画展示点击事件
     * @param view
     */
    public void onViewAnimClick(View view){
        startActivity(new Intent(this,ViewAnimationActivity.class));
    }


    /**
     * 属性动画展示点击事件
     * @param view
     */
    public void onObjectAnimClick(View view){
         startActivity(new Intent(this,ObjectAnimationActivity.class));
    }



    public void onMenuAnimClick(View view){
        startActivity(new Intent(this,MenuOpenAnimActivity.class));
    }




}
