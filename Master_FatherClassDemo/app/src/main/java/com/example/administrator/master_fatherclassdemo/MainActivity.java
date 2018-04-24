package com.example.administrator.master_fatherclassdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mBt_father;
    private Button mBt_sub;
    private TextView mTv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBt_father = (Button) findViewById(R.id.bt_father);
        mBt_sub = (Button) findViewById(R.id.bt_sub);
        mTv_show = (TextView) findViewById(R.id.tv_show);




        mBt_father.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FatherClass fatherClass = new FatherClass();
                fatherClass.normalMethod();
            }
        });

        mBt_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 SubClass subClass = new SubClass();
                subClass.normalMethod();
            }
        });
    }
}
