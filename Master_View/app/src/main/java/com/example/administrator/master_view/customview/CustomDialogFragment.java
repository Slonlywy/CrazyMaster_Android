package com.example.administrator.master_view.customview;


import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.administrator.master_view.R;

/**
 * Created by 黄伟嘉 on 2017/12/27/
 * 一个继承DialogFragment的自定义Dialog
 * 优点：更好的管理对话框的生命周期
 *
 * 使用DialogFragment至少需要实现onCreateView或者onCreateDIalog方法。
 * onCreateView即使用定义的xml布局文件展示Dialog。
 * onCreateDialog即利用AlertDialog或者Dialog创建出Dialog。
 */

public class CustomDialogFragment extends DialogFragment {


    private onContentListener mOnContentListener;

    public onContentListener getOnContentListener() {
        return mOnContentListener;
    }

    public void setOnContentListener(onContentListener onContentListener) {
        mOnContentListener = onContentListener;
    }


    /**
     * 方法一：
     * 是将自己的Xml转化成View显示在Dialog上
     */
   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //去掉上面空白标题
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.custom_dialogview, container);
        return view;
    }*/


    /**
     * 方法二：
     * 创建一个Dialog来显示
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.custom_dialogview, null);
        final EditText account = (EditText) view.findViewById(R.id.account);
        final EditText password = (EditText) view.findViewById(R.id.password);
        AlertDialog alertDialog=new AlertDialog.Builder(getActivity())
                .setView(view)
                .setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (mOnContentListener != null) {
                            mOnContentListener.getContent(account.getText().toString().trim(),
                                    password.getText().toString().trim());
                        }
                    }
                })
                .setNegativeButton("Cancel",null)
                .create();
        return alertDialog;
    }


    /**
     * 接口 传递账号密码
     */
    public interface onContentListener{
        void getContent(String account,String password);
    }
}
