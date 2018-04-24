package com.example.administrator.master_view.ui;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.master_view.R;
import com.example.administrator.master_view.customview.CustomDialogFragment;

public class Demo_AlertDialogActivity extends AppCompatActivity implements View.OnClickListener, CustomDialogFragment.onContentListener {

    private TextView mTv_ad1;
    private int mWidth;
    private int mHeight;
    private TextView mTv_adlist;

    //数组，添加列表Dialog中的Item
    private String[] mStringItems={"Item_one","Item_two","Item_three","Item_four"};
    private TextView mTv_adlist_singlechoice;
    private TextView mTv_adlist_multichoice;
    private TextView mTv_adcustomview;
    private TextView mTv_ad_dialogFragment;
    private TextView mTv_ad_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo__alert_dialog);
        //获取屏幕宽高
        WindowManager wm = (WindowManager) this.getSystemService(WINDOW_SERVICE);
        mWidth = wm.getDefaultDisplay().getWidth();
        mHeight = wm.getDefaultDisplay().getHeight();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initView();
        initClick();
    }

    private void initClick() {
        mTv_ad1.setOnClickListener(this);
        mTv_adlist.setOnClickListener(this);
        mTv_adlist_singlechoice.setOnClickListener(this);
        mTv_adlist_multichoice.setOnClickListener(this);
        mTv_adcustomview.setOnClickListener(this);
        mTv_ad_dialogFragment.setOnClickListener(this);
        mTv_ad_animation.setOnClickListener(this);
    }

    private void initView() {
        mTv_ad1 = (TextView) findViewById(R.id.alertdialog_1);
        mTv_adlist = (TextView) findViewById(R.id.alertdialog_list);
        mTv_adlist_singlechoice = (TextView) findViewById(R.id.alertdialog_list_singlechoice);
        mTv_adlist_multichoice = (TextView) findViewById(R.id.alertdialog_list_multichoice);
        mTv_adcustomview = (TextView) findViewById(R.id.alertdialog_customview);
        mTv_ad_dialogFragment = (TextView) findViewById(R.id.alertdialog_dialogfragment);
        mTv_ad_animation = (TextView) findViewById(R.id.alertdialog_animation);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.alertdialog_1:
                createDialog1();
                break;
            case R.id.alertdialog_list:
                createAlertDialog_List();
                break;
            case R.id.alertdialog_list_singlechoice:
                createAlertDialog_List_SingleChoice();
                break;
            case R.id.alertdialog_list_multichoice:
                createAlertDialog_List_MultiChoice();
                break;
            case R.id.alertdialog_customview:
                createAlertDialog_CustomView();
                break;
            case R.id.alertdialog_dialogfragment:
                showDialogFragment();
                break;
            case R.id.alertdialog_animation:
                createAlertDialog_Animation();
                break;
        }
    }

    /**
     * 动画效果的Dialog
     */
    private void createAlertDialog_Animation() {
        AlertDialog alertDialog=new AlertDialog.Builder(this)
                .setTitle("动画效果的Dialog")
                .setIcon(R.mipmap.ic_launcher_round)
                .setMessage("弹出效果")
                .create();

        Window window = alertDialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.DialogAnimation);
        alertDialog.show();
    }

    /**
     * 显示Dialog
     */
    private void showDialogFragment() {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        customDialogFragment.show(getFragmentManager(),"CustomDialogFragment");
        customDialogFragment.setOnContentListener(this);
    }

    /**
     * 自定义View的Dialog
     */
    private void createAlertDialog_CustomView() {

        View inflate = LayoutInflater.from(this).inflate(R.layout.custom_dialogview, null);

        AlertDialog alertDialog=new AlertDialog.Builder(this)
                .setTitle(R.string.alertdialog_customName)
                .setIcon(R.mipmap.ic_launcher_round)
                .setView(inflate)
                .create();
        alertDialog.show();

        //设置dialog显示的位置
        Window window = alertDialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
    }

    /**
     * 多选形式的列表
     */
    private void createAlertDialog_List_MultiChoice() {
        AlertDialog alertDialog=new AlertDialog.Builder(this)
                .setTitle(R.string.alertdialog_listName)
                .setIcon(R.mipmap.ic_launcher_round)
                  //设置以多选形式显示，参数二是布尔数组，制定默认选中的item
                 .setMultiChoiceItems(mStringItems, new boolean[]{true, false, true,false}, new DialogInterface.OnMultiChoiceClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                         Toast.makeText(Demo_AlertDialogActivity.this, "点击了:"+mStringItems[i], Toast.LENGTH_SHORT).show();
                     }
                 })
                .create();
        alertDialog.show();
    }

    /**
     * 单选形式的列表
     */
    private void createAlertDialog_List_SingleChoice() {
        AlertDialog alertDialog=new AlertDialog.Builder(this)
                .setTitle(R.string.alertdialog_listName)
                .setIcon(R.mipmap.ic_launcher_round)
                //列表以单选形式显示， 1 是指默认选中位置
                .setSingleChoiceItems(mStringItems, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Demo_AlertDialogActivity.this, "点击了:" + mStringItems[i], Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        alertDialog.show();
    }

    /**
     * 列表形式的Dialog
     * 不能滑动
     */
    private void createAlertDialog_List() {
        AlertDialog alertDialog=new AlertDialog.Builder(this)
                .setTitle(R.string.alertdialog_listName)
                .setIcon(R.mipmap.ic_launcher_round)
                //添加列表内容
                .setItems(mStringItems, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Demo_AlertDialogActivity.this, "点击了:"+mStringItems[i], Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        alertDialog.show();
    }


    /**
     * 最原始的Dialog
     * 缺点：界面单调
     */
    private void createDialog1() {
        AlertDialog alertDialog= new AlertDialog.Builder(this)
                .setTitle(R.string.alertdialog_name)  //设置标题
                .setIcon(R.mipmap.ic_launcher_round)  //设置图标
                .setMessage(R.string.alertdialog_message)    //设置内容
                .setCancelable(false)                 //设置是否可以点击取消，true点击外部则可以消失
                .setPositiveButton(R.string.alertdialog_PositiveButton, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Demo_AlertDialogActivity.this, "点击了确定", Toast.LENGTH_SHORT).show();
                    }
                })                                    //确定点击事件
                .setNegativeButton(R.string.alertdialog_NegativeButton, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Demo_AlertDialogActivity.this, "点击了取消", Toast.LENGTH_SHORT).show();
                    }
                })                                    //取消点击事件
                .create();
        alertDialog.show();
    }


    /**
     * 输入账号密码接口回调
     * @param account
     * @param password
     */
    @Override
    public void getContent(String account, String password) {
        Toast.makeText(this, "账号："+account+"密码："+password, Toast.LENGTH_SHORT).show();
    }
}
