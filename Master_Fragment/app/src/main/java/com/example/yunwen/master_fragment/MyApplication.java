package com.example.yunwen.master_fragment;

import android.app.Application;
import android.content.Context;

/**
 * Created by 黄伟嘉 on 2018/1/29.
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
    }
}
