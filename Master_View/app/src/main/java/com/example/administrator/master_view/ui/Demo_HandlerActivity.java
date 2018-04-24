package com.example.administrator.master_view.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.master_view.R;

public class Demo_HandlerActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTv_title;
    private Button mBt_change;
    private Button mBt_asyncTask;
    private Button mBt_photoPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo__handler);

        initView();
        initClick();
    }

    private void initClick() {
        mBt_change.setOnClickListener(this);
        mBt_asyncTask.setOnClickListener(this);
    }

    private void initView() {
        mTv_title = (TextView) findViewById(R.id.tv_title);
        mBt_change = (Button) findViewById(R.id.bt_change);
        mBt_asyncTask = (Button) findViewById(R.id.bt_AsyncTask);
        mBt_photoPreview = (Button) findViewById(R.id.bt_photoPreview);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_change:
                //发送一个消息Message
                sendUIMessage();
                break;
            case R.id.bt_AsyncTask:
                Intent intent = new Intent(this,Demo_AsyncTaskActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    /**
     * 子线程中发送一个消息
     */
    private void sendUIMessage() {
       new Thread(new Runnable() {
           @Override
           public void run() {
               Message message = new Message();
               message.what=0x1;
               mHandler.sendMessage(message);
           }
       }).start();
    }


    /**
     * 主线程中实例化Handler对象
     */
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0x1:
                    // TODO: 2018/1/16 Update UI content
                        mTv_title.setText("你好吗");
                    break;
            }
        }
    };
}
