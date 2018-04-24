package com.example.administrator.master_view.ui;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.master_view.R;
import com.example.administrator.master_view.customview.CustomAsyncTask;

public class Demo_AsyncTaskActivity extends AppCompatActivity {

    private ProgressDialog mDialog;
    private TextView mProgress_show;
    private CustomAsyncTask mCustomAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo__async_task);

        mProgress_show = (TextView) findViewById(R.id.progress_show);

        mDialog = new ProgressDialog(this);
        mDialog.setMax(100);
        mDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mDialog.setCancelable(false);


        mCustomAsyncTask = new CustomAsyncTask(this, mDialog, mProgress_show);
        mCustomAsyncTask.execute();
    }
}
