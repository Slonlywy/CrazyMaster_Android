package com.example.administrator.master_view.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.example.administrator.master_view.R;

import java.util.ArrayList;
import java.util.List;

public class MenuOpenAnimActivity extends AppCompatActivity implements View.OnClickListener {

    private int[] image_res = {R.id.a, R.id.b, R.id.c, R.id.d,
            R.id.e, R.id.f, R.id.g, R.id.h};


    private List<ImageView> mImageViewList = new ArrayList<>();


    private boolean isShowMenu = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_open_anim);

        for (int i = 0; i < image_res.length; i++) {
            ImageView imageView = (ImageView) findViewById(image_res[i]);
            imageView.setOnClickListener(this);
            mImageViewList.add(imageView);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.a:
                if (!isShowMenu) {
                    openMenuAnim();
                } else {
                    closeMenuAnim();
                }
                break;
            default:
                break;
        }
    }

    /**
     * 关闭菜单动画
     */
    private void closeMenuAnim() {
        for (int i = 1; i < mImageViewList.size(); i++) {
            ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(mImageViewList.get(i), "translationX", i * 100, 0f);
            ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(mImageViewList.get(i), "translationY", i * 150, 0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorX, objectAnimatorY);
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            animatorSet.setDuration(1000);
            animatorSet.start();
        }
        isShowMenu=false;
    }

    /**
     * 打开菜单动画
     */
    private void openMenuAnim() {
        for (int i = 1; i < mImageViewList.size(); i++) {
            ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(mImageViewList.get(i), "translationX", 0F, i * 100);
            ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(mImageViewList.get(i), "translationY", 0F, i * 150);

            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorX, objectAnimatorY);
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            animatorSet.setDuration(1000);
            animatorSet.start();
        }
        isShowMenu = true;
    }
}
