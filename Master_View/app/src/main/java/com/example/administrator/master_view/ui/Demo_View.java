package com.example.administrator.master_view.ui;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.master_view.R;

public class Demo_View extends AppCompatActivity implements View.OnClickListener {

    private Button mBt_picture;
    private Button mBt_customview;
    private Button mBt_neonlight;
    private Button mBt_camera;
    private Button mBt_alertdialog;
    private Button mBt_animation;
    private Button mBt_custom_view;
    private Button mBt_listview;
    private Button mBt_handler;
    private Button mBt_customActivityOnCrash;
    private Button mBt_recyclerView;
    private Button mChatActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 添加View 的两种方式
         * XML设置布局   简单、方便、便捷
         * Java中设置    不利于解耦，显得臃肿
         */
//     ①   setContentView(R.layout.activity_demo__view);
//     ②
        View inflate = LayoutInflater.from(this).inflate(R.layout.activity_demo__view, null);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);
        linearLayout.addView(inflate);


        //动态添加TextView
        TextView textView = new TextView(this);
        textView.setText("动态添加TextView");
        //动态设置大小
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT
        , ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.addView(textView);


        /**=================================动态设置属性==========================*/
        //initAlpha();
       // initElevation();
        initButton();
        initEvent();
    }

    private void initEvent() {
        mBt_picture.setOnClickListener(this);
        mBt_custom_view.setOnClickListener(this);
        mBt_customview.setOnClickListener(this);
        mBt_neonlight.setOnClickListener(this);
        mBt_camera.setOnClickListener(this);
        mBt_alertdialog.setOnClickListener(this);
        mBt_animation.setOnClickListener(this);
        mBt_listview.setOnClickListener(this);
        mBt_recyclerView.setOnClickListener(this);
        mBt_handler.setOnClickListener(this);
        mBt_customActivityOnCrash.setOnClickListener(this);
        mChatActivity.setOnClickListener(this);
    }

    private void initButton() {
        mBt_picture = (Button) findViewById(R.id.bt_picture);
        mBt_custom_view = (Button) findViewById(R.id.bt_custom_view);
        mBt_customview = (Button) findViewById(R.id.bt_customview);
        mBt_neonlight = (Button) findViewById(R.id.bt_neonlight);
        mBt_camera = (Button) findViewById(R.id.bt_camera);
        mBt_alertdialog = (Button) findViewById(R.id.bt_alertdialog);
        mBt_animation = (Button) findViewById(R.id.bt_animation);
        mBt_listview = (Button) findViewById(R.id.bt_Listview);
        mBt_recyclerView = (Button) findViewById(R.id.bt_RecyclerView);
        mChatActivity = (Button) findViewById(R.id.bt_ChatActivity);
        mBt_handler = (Button) findViewById(R.id.bt_handler);
        mBt_customActivityOnCrash = (Button) findViewById(R.id.bt_CustomActivityOnCrash);
    }

    private void initElevation() {
        TextView elevation_3D = (TextView) findViewById(R.id.elevation_3D);
        //api>=21
       // elevation_3D.setElevation(6.0f);
    }

    /**
     * 设置控件透明度属性
     *   0.0f<=f<=1.0f
     */
    private void initAlpha() {
        TextView alpha_80 = (TextView) findViewById(R.id.alpha_80);
        alpha_80.setAlpha(0.8f);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //简单的图片浏览
            case R.id.bt_picture:
                Intent intent = new Intent(this, Demo_SimplePictureBrowsingActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_custom_view:
                Intent intent0 = new Intent(this, Demo_CustomViewActivity.class);
                startActivity(intent0);
                break;
            //自定义随手指移动的view
            case R.id.bt_customview:
                Intent intent1 = new Intent(this, Demo_CustomCircleViewActivity.class);
                startActivity(intent1);
                break;
            //霓虹灯
            case R.id.bt_neonlight:
                Intent intent2 = new Intent(this, Demo_NeonLightActivity.class);
                startActivity(intent2);
                break;
            //相机
            case R.id.bt_camera:
                Intent intent3 = new Intent(this, Demo_CameraActivity.class);
                startActivity(intent3);
                break;
            //Dialog
            case R.id.bt_alertdialog:
                Intent intent4 = new Intent(this, Demo_AlertDialogActivity.class);
                startActivity(intent4);
                break;
            //Animation动画
            case R.id.bt_animation:
                Intent intent5 = new Intent(this, Demo_AnimationActivity.class);
                startActivity(intent5);
                break;
            case R.id.bt_Listview:
                Intent intent6 = new Intent(this, Demo_ListViewActivity.class);
                startActivity(intent6);
                break;
            case R.id.bt_RecyclerView:
                Intent intent8 = new Intent(this,Demo_RecyclerViewActivity.class);
                startActivity(intent8);
                break;
            case R.id.bt_ChatActivity:
                Intent intent9 = new Intent(this, Demo_ChatActivity.class);
                startActivity(intent9);
                break;
            case R.id.bt_handler:
                Intent intent7 = new Intent("com.example.ACTION_START");
                startActivity(intent7);
                break;
            case R.id.bt_CustomActivityOnCrash:
                int i = 1 / 0;
                Toast.makeText(this, i+"", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    /**
     * 菜单栏
     * @param menu
     * @return  true则是显示 ，false则不显示
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    /**
     * 菜单item点击事件
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                Toast.makeText(this, "点击添加按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this, "点击删除按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sure:
                Toast.makeText(this, "点击确定按钮", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
