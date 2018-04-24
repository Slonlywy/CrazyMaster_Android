package com.example.administrator.master_view;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.vise.log.ViseLog;
import com.vise.log.inner.LogcatTree;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;

/**
 * Created by 黄伟嘉 on 2017/12/19/019.
 */

public class MyApplication extends Application {

    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    public void setContext(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
        /** 崩溃抓包工具初始化 */
        CustomActivityOnCrash.install(this);
        initViseLog();
    }

    /**
     * 初始化ViseLog日志
     */
    private void initViseLog() {
        ViseLog.getLogConfig()
                .configAllowLog(true)//是否输出日志
                .configShowBorders(true)//是否排版显示
                .configTagPrefix("ViseLog")//设置标签前缀
                .configFormatTag("%d{HH:mm:ss:SSS} %t %c{-5}")//个性化设置标签，默认显示包名
                .configLevel(Log.VERBOSE);//设置日志最小输出级别，默认Log.VERBOSE
        ViseLog.plant(new LogcatTree());//添加打印日志信息到Logcat的树
    }
}
