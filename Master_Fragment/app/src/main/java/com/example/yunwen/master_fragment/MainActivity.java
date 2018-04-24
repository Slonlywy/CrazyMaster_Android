package com.example.yunwen.master_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.yunwen.master_fragment.fragment.AnotherRightFragment;
import com.example.yunwen.master_fragment.fragment.RightFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBt_addFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initClickListener();
        replaceFragment(new RightFragment());
    }

    private void initClickListener() {
        mBt_addFragment.setOnClickListener(this);
    }

    private void initView() {
        mBt_addFragment = (Button) findViewById(R.id.bt_leftfragment);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_leftfragment:
                replaceFragment(new AnotherRightFragment());
                break;
            default:
                break;
        }
    }

    /**
     * 动态替换Fragment
     * @param fragment
     */
    private void replaceFragment(Fragment fragment) {
        //获取FragmentManager管理类
        FragmentManager manager = getSupportFragmentManager();
        //管理类开启事务
        FragmentTransaction transaction = manager.beginTransaction();
        //事务替换Fragment
        transaction.replace(R.id.frame_layout,fragment);
        //将一个事务添加到返回栈中
        transaction.addToBackStack(null);//执行此代码之后，按下返回键会发现返回到替换之前的Fragment。
        //提交
        transaction.commit();
    }
}

/**
 * 执行上述代码后会发现动态替换过Fragment之后按返回键会发现直接退出程序
 * 因此添加addToBackStack（）；
 */