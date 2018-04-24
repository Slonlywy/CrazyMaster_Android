package com.example.administrator.master_view.ui;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.master_view.R;
import com.example.administrator.master_view.constant.Config;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 霓虹灯效果
 * 布局采用帧布局FrameLayout
 * create by 黄伟嘉 on 2017/12/18
 * 疯狂讲义P57
 */
public class Demo_NeonLightActivity extends AppCompatActivity {
    //当前背景色
    private int currentColor = 0;

    private final int[] names = {
            R.id.tv_01,
            R.id.tv_02,
            R.id.tv_03,
            R.id.tv_04,
            R.id.tv_05,
            R.id.tv_06};

    //实例化一个textview数组
    TextView[] views = new TextView[names.length];

    //线程改变背景色
    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    for (int i = 0; i < names.length; i++) {
                        views[i].setBackgroundResource(Config.colors[(i+currentColor)%names.length]);
                    }
                    currentColor++;
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neon_light);

        for (int i = 0; i < names.length; i++) {
            views[i] = (TextView) findViewById(names[i]);
        }

        //计时器每隔0.2s
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //发送一条消息通知改变颜色
                mHandler.sendEmptyMessage(1);
            }
        },0,200);
    }
}
