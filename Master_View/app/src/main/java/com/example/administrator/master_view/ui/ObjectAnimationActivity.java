package com.example.administrator.master_view.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;

import com.example.administrator.master_view.R;

public class ObjectAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animation);
    }

    /**
     * 简单的属性动画
     *
     * @param view
     */
    public void onIV6click(final View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "zhy", 1.0f, 0.0f);
        animator.setDuration(3000).start();

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedValue = (float) valueAnimator.getAnimatedValue();
                view.setAlpha(animatedValue);
                view.setScaleX(animatedValue);
                view.setScaleY(animatedValue);
            }
        });
    }


    /**
     * 多属性动画同时工作管理类
     *
     * @param view
     */
    public void onIV5click(View view) {
        //多个动画同时执行
        PropertyValuesHolder translationX = PropertyValuesHolder.ofFloat("translationX", 0f, 200 + view.getWidth());
        PropertyValuesHolder translationY = PropertyValuesHolder.ofFloat("translationY", 0f, 200 + view.getHeight());
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, translationX, translationY);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }


    /**
     * 使用动画集合AnimatorSet来播放
     *
     * @param view
     */
    public void onIV4click(View view) {

        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display defaultDisplay = wm.getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();

        //多个动画同时执行
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ObjectAnimator translationX = ObjectAnimator.ofFloat(view, "translationX", 0, width - view.getWidth());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(3000);
        animatorSet.setInterpolator(new LinearInterpolator());
        //同时播放
//        animatorSet.playTogether(alpha,translationX);
        //设置执行顺序
        animatorSet.play(alpha).after(translationX);
        //....其他组合方式
        animatorSet.start();
    }


    /**
     *  通过计算值来随机
     *  Evaluators就是属性动画系统如何去计算一个属性值
     * @param view
     */
    public void onIV3click(final View view) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(5000);
        valueAnimator.setObjectValues(new float[2]);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator<float[]>() {
            @Override
            public float[] evaluate(float fraction, float[] startValue, float[] endValue) {
                //实现自定义规则计算的float[]类型的属性值
                float[] temp = new float[2];
                temp[0] = (float) Math.random() * 10 * fraction;
                temp[1] = (float) Math.random() * 10 * fraction;
                return temp;
            }
        });

        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float[] f = (float[]) valueAnimator.getAnimatedValue();
                view.setScaleX(f[0]);
                view.setScaleY(f[1]);
            }
        });
    }

    public void onBallClick(View view){
        startActivity(new Intent(this,ParabolaActivity.class));
    }
}
