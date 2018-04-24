package com.example.administrator.master_view.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 黄伟嘉 on 2017/12/18/018.
 * 自定义View   小球跟随手指移动
 * 代码参考疯狂讲义 P48
 */

public class CustomCircleView extends View {

    //当前小球的位置
    public float currentX=30;
    public float currentY=30;

    //实例化一个画笔
    private Paint mPaint=new Paint();

    public CustomCircleView(Context context) {
        super(context);
    }

    public CustomCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 绘制内容
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //给画笔设置颜色
        mPaint.setColor(Color.RED);
        //画布画圆，制定圆心坐标、半径以及画笔
        canvas.drawCircle(currentX,currentY,30,mPaint);
    }


    /**
     * 当发生触摸屏时重写该方法，为组件的触摸事件重写
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //获取手指动作的位置来给当前位置X、Y坐标重新赋值
        currentX=event.getX();
        currentY=event.getY();

        //通知重新绘制自己
        invalidate();

        //返回true则表示该方法已经处理过该事件,当手指滑动时也跟随一起
        return true;
    }
}
