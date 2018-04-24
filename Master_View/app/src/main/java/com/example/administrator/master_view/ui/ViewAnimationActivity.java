package com.example.administrator.master_view.ui;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.master_view.R;

/**
 * Created by yunwen on 2018/4/23.
 */

public class ViewAnimationActivity extends AppCompatActivity {


    private ImageView mIv_frame;
    private TextView mTv_scale;
    private ImageView mIv_scale;
    private TextView mTv_rotate;
    private ImageView mIv_rotate;
    private TextView mTv_translate;
    private ImageView mIv_translate;
    private TextView mTv_alpha;
    private ImageView mIv_alpha;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo__animation);
        initClick();
    }

    private void initClick() {
        findViewById(R.id.bt_alpha).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initAlpha();
            }
        });


        findViewById(R.id.bt_translate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initTranSlate();
            }
        });


        findViewById(R.id.bt_rotate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initRotate();
            }
        });


        findViewById(R.id.bt_scale).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initScale();
            }
        });


        findViewById(R.id.bt_frame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initFrame();
            }
        });
    }


    /**
     * 帧动画
     */
    private void initFrame() {
        mIv_frame = (ImageView) findViewById(R.id.iv_frame);
        mIv_frame.setBackgroundResource(R.drawable.anim_frame);

        AnimationDrawable anim = (AnimationDrawable) mIv_frame.getBackground();
        anim.start();
    }

    /**
     * 缩放
     * 自身放大1倍
     */
    private void initScale() {
        mTv_scale = (TextView) findViewById(R.id.tv_scale);
        mIv_scale = (ImageView) findViewById(R.id.iv_scale);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        animation.setDuration(5000);
        mTv_scale.startAnimation(animation);
        mIv_scale.startAnimation(animation);

        //设置动画监听
        animation.setAnimationListener(mAnimationListener);

    }

    /**
     * 旋转动画
     * 以（0,0）旋转360度
     */
    private void initRotate() {
        mTv_rotate = (TextView) findViewById(R.id.tv_rotate);
        mIv_rotate = (ImageView) findViewById(R.id.iv_rotate);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        animation.setDuration(5000);
        mTv_rotate.startAnimation(animation);
        mIv_rotate.startAnimation(animation);
        //设置动画监听
        animation.setAnimationListener(mAnimationListener);
    }

    /**
     * 位移动画
     */
    private void initTranSlate() {
        mTv_translate = (TextView) findViewById(R.id.tv_translate);
        mIv_translate = (ImageView) findViewById(R.id.iv_translate);

        Animation animationX = AnimationUtils.loadAnimation(this, R.anim.anim_translate_x);
        Animation animationY = AnimationUtils.loadAnimation(this, R.anim.anim_translate_y);

        animationX.setDuration(5000);
        animationY.setDuration(5000);
        mTv_translate.startAnimation(animationY);
        mIv_translate.startAnimation(animationX);
        //设置动画监听
        animationX.setAnimationListener(mAnimationListener);
        animationY.setAnimationListener(mAnimationListener);

        /**
         * 补间动画执行之后并未改变View的真实布局属性值。切记这一点，
         * 譬如我们在Activity中有一个Button在屏幕上方，我们设置了平移动画移动到屏幕下方然后保持动画最后执行状态呆在屏幕下方，
         * 这时如果点击屏幕下方动画执行之后的Button是没有任何反应的，而点击原来屏幕上方没有Button的地方却响应的是点击Button的事件
         */
        mTv_translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ViewAnimationActivity.this, "位移点击监听事件", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * 透明度动画
     */
    private void initAlpha() {
        mTv_alpha = (TextView) findViewById(R.id.tv_alpha);
        mIv_alpha = (ImageView) findViewById(R.id.iv_alpha);
        //加载动画资源
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
/*        //设置动画变化速度 加速
        animation.setInterpolator(new AccelerateInterpolator());
        //先加速后减速
       animation.setInterpolator(new AccelerateDecelerateInterpolator());*/
        //动画结束后弹起插值器
        animation.setInterpolator(new BounceInterpolator());
        //控件设置动画对象
        mTv_alpha.startAnimation(animation);
        mIv_alpha.startAnimation(animation);

        //设置动画监听
        animation.setAnimationListener(mAnimationListener);

    }

    private Animation.AnimationListener mAnimationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

}
