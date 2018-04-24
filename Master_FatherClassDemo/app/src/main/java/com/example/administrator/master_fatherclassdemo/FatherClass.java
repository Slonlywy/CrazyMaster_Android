package com.example.administrator.master_fatherclassdemo;

import com.vise.log.ViseLog;

/**
 * Created by Administrator on 2018/1/23.
 */

public class FatherClass {
    static {
        ViseLog.d("父类静态代码块");
    }

    FatherClass(){
        ViseLog.d("父类构造方法");
    }

    {
     ViseLog.d("父类非静态代码块");
    }

    public void normalMethod(){
        ViseLog.d("父类普通方法");
    }
}
