package com.example.administrator.master_fatherclassdemo;

import com.vise.log.ViseLog;

/**
 * Created by Administrator on 2018/1/23.
 */

public class SubClass extends FatherClass {
    static {
        ViseLog.d("子类静态代码块");
    }

    SubClass() {
      ViseLog.d("子类构造方法");
    }

    {
        ViseLog.d("子类非静态代码块");
    }


    @Override
    public void normalMethod() {
        super.normalMethod();
        ViseLog.d("父类的普通方法");
    }
}
