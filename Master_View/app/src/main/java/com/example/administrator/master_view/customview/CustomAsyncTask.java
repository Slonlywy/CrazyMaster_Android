package com.example.administrator.master_view.customview;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/1/16.
 */

public class CustomAsyncTask extends AsyncTask<Void,Integer,Boolean> {

    private ProgressDialog mDialog;
    private TextView mTextView;
    private Context mContext;
    private static final String TAG="CustomAsyncTask";


    public CustomAsyncTask(Context context,ProgressDialog dialog,TextView textView) {
        this.mContext=context;
        this.mDialog=dialog;
        this.mTextView=textView;
    }

    /**
     * 主要做一些初始化操作
     */
    @Override
    protected void onPreExecute() {
        Log.i(TAG,Thread.currentThread().getName()+"====onPreExecute");
        super.onPreExecute();
        mDialog.show();
    }

    /**
     * 执行在子线程中，处理耗时操作
     * @param voids
     * @return
     */
    @Override
    protected Boolean doInBackground(Void... voids) {
        Log.i(TAG,Thread.currentThread().getName()+"====doInBackground");
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }
        return null;
    }


    /**
     * 更新进度
     * @param values
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        Log.i(TAG,Thread.currentThread().getName()+"====onProgressUpdate");
        super.onProgressUpdate(values);
        mDialog.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        Log.i(TAG,Thread.currentThread().getName()+"====onPostExecute");
        super.onPostExecute(aBoolean);
        mDialog.dismiss();
        mTextView.setText("Load Finished！！！");
    }
}
