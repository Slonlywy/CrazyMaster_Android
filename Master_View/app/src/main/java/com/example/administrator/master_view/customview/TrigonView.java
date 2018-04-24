package com.example.administrator.master_view.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by 黄伟嘉 on 2017/12/28/028.
 * 自定义三角形View
 */

public class TrigonView extends View {
    public TrigonView(Context context) {
        super(context);
    }

    public TrigonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();

        //左上角的直角三角形
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        //实例化路径
        Path path = new Path();
        //起点
        path.moveTo(0, 0);
        //划线至第一个拐点
        path.lineTo(600, 0);
        //划线至第二个拐点
        path.lineTo(0, 800);
        //闭合，划线连接起始点和最后一个拐点
        path.close();
        canvas.drawPath(path, paint);

        //右下角的等腰三角形
        Paint paint1 = new Paint();
        paint1.setAntiAlias(true);
        paint1.setColor(Color.GRAY);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(2.0f);
        Path path1 = new Path();
        path1.moveTo(width, height);
        path1.lineTo(width - 300, height - 800);
        path1.lineTo(width - 600, height);
        path1.close();
        canvas.drawPath(path1, paint1);


        Path path2 = new Path();
        path2.moveTo(width-400,0);
        path2.lineTo(width,400);
        path2.lineTo(width/2,height/2);
        path2.lineTo(400,height);
        path2.lineTo(0,height-400);
        path2.lineTo(width/2,height/2);
        path2.close();
        canvas.drawPath(path2,paint);
    }
}
