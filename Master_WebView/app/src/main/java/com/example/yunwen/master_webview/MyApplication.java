package com.example.yunwen.master_webview;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.vise.log.ViseLog;
import com.vise.log.inner.LogcatTree;

/**
 * Created by Administrator on 2018/1/8.
 */

public class MyApplication extends Application {

    private Context mContext;


    public Context getContext() {
        return mContext;
    }

    public void setContext(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
        initViseLog();
    }

    private void initViseLog() {
        ViseLog.getLogConfig()
                .configAllowLog(true)
                .configShowBorders(true)
                .configTagPrefix("ViseLog")
                .configFormatTag("%d{HH:mm:ss:SSSS} %t %c{-5}")
                .configLevel(Log.VERBOSE);
        ViseLog.plant(new LogcatTree());
    }
}
