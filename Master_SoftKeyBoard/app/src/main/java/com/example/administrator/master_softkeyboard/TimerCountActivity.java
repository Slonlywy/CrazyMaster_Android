package com.example.administrator.master_softkeyboard;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.InputEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimerCountActivity extends AppCompatActivity implements View.OnLayoutChangeListener {

    private int mWidth;
    private int mHeight;
    private int mKeyHeight;
    private LinearLayout mRoot_activity;
    private boolean isShowSoftKeyBoard = false;

    private long oldTime = 0;
    private CountTimeThread mCountTimeThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindowWidthAndHeight();
        mRoot_activity = (LinearLayout) findViewById(R.id.root_activity);

        oldTime = Calendar.getInstance().getTimeInMillis();

        mCountTimeThread = new CountTimeThread();
        mCountTimeThread.start();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mRoot_activity.addOnLayoutChangeListener(this);
        oldTime = Calendar.getInstance().getTimeInMillis();
        Log.e("oldTime====", oldTime + "");
    }


    class CountTimeThread extends Thread {
        @Override
        public void run() {
            super.run();
            Message message = new Message();
            message.what = 0x1;
            mHandler.sendMessageDelayed(message,1000);
        }
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0x1:
                    long timeInMillis = Calendar.getInstance().getTimeInMillis();
                    Log.e("timeInMillis====", timeInMillis + "" + "\n" + "" + (timeInMillis - oldTime));
                    if ((timeInMillis - oldTime) > 10000) {
                        finish();
                    }
                    break;
            }
        }
    };


    /**
     * 获取屏幕宽高
     */
    private void getWindowWidthAndHeight() {
        WindowManager wm = this.getWindowManager();
        Display defaultDisplay = wm.getDefaultDisplay();
        mWidth = defaultDisplay.getWidth();
        mHeight = defaultDisplay.getHeight();

        mKeyHeight = mHeight / 3;
    }

    /**
     * 监听布局改变
     *
     * @param view
     * @param left
     * @param top
     * @param right
     * @param bottom
     * @param oldLeft
     * @param oldTop
     * @param oldRight
     * @param oldBottom
     */
    @Override
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        if (oldBottom != 0 && bottom != 0 && (oldBottom - bottom > mKeyHeight)) {
            Toast.makeText(this, "键盘被弹起", Toast.LENGTH_SHORT).show();
        } else if (oldBottom != 0 && bottom != 0 && (bottom - oldBottom > mKeyHeight)) {
            Toast.makeText(this, "键盘被隐藏", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
