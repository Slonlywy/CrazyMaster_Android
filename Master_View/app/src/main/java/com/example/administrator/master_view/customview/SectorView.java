package com.example.administrator.master_view.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 黄伟嘉 on 2017/12/28/028.
 * 自定义扇形View
 */

public class SectorView extends View {
    public SectorView(Context context) {
        super(context);
    }

    public SectorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        RectF rectF = new RectF(60, 100, 200, 240);

        Paint paint1 = new Paint();
        paint1.setAntiAlias(true);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setColor(Color.RED);

        canvas.drawRect(rectF,paint1);
        canvas.drawArc(rectF,200,130,true,paint);
    }
}
