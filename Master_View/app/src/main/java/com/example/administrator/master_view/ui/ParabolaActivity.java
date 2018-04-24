package com.example.administrator.master_view.ui;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.example.administrator.master_view.R;

public class ParabolaActivity extends AppCompatActivity {

    private ImageView mIv_earth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parabola);
        mIv_earth = (ImageView) findViewById(R.id.iv_earth);
    }

    public void onParabolaClick(final View view){
        PointF pointF = new PointF(0,0);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(3000);
        valueAnimator.setObjectValues(pointF);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
            //fraction = t / duration
            @Override
            public PointF evaluate(float fraction, PointF startpointF, PointF endpointF) {
                Log.e("Fraction = :",fraction*3+"");
                // x方向200px/s ，则y方向0.5 * 10 * t
                PointF point = new PointF();
                point.x = 200 * fraction * 3;
                point.y = 0.5f * 200 * (fraction * 3) * (fraction * 3);
                return point;
            }
        });

        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                PointF point = (PointF) animation.getAnimatedValue();
                mIv_earth.setX(point.x);
                mIv_earth.setY(point.y);
            }
        });
    }
}
