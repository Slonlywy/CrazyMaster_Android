package com.example.yunwen.master_richtext.richText;

import android.content.Context;

/**
 * Created by chenhaohui on 16/5/22.
 */
public class MoonDensityUtil {


    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}


