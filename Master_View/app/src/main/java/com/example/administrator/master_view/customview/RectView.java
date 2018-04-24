package com.example.administrator.master_view.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 黄伟嘉 on 2017/12/28/028.
 * 自定义矩形View
 */

public class RectView extends View {
    public RectView(Context context) {
        super(context);
    }

    public RectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //实例化画笔
        Paint paint = new Paint();

        //画笔抗锯齿
        paint.setAntiAlias(true);

        //空心
        paint.setStyle(Paint.Style.STROKE);

        paint.setColor(Color.BLACK);
        //左上角（100,100）
        //右上角（500,100）
        //右下角（500,300）
        //长：400，宽：200的矩形
        canvas.drawRect(100,100,500,300,paint);
    }
}
