package com.example.yunwen.master_notification_demo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onSendNotice(View view){

        Intent intent = new Intent(this,PendingIntentActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);


        //通知管理类
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //通过NotificationCompat创建通知
        Notification notification = new NotificationCompat.Builder(this)
                //标题
                .setContentTitle("Notification")
                //内容
                .setContentText("This is a Notification! Do something what you want to do ...................................")
                //时间
                .setWhen(System.currentTimeMillis())
                //自动取消
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.zhaolvshi)
                .setContentIntent(pendingIntent)
                .setVibrate(new long[]{0,1000,1000,1000})
                .setLights(Color.GREEN,5000,3000)
                .build();

        //发送通知
        nm.notify(1,notification);
    }
}
