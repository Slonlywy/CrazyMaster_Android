package com.example.administrator.master_view.bean;

/**
 * Created by yunwen on 2018/1/26.
 */

public class Msg {
    /** 类型为接收*/
    public  static final int TYPE_RECEIVE=0;
    /** 类型为发送*/
    public static final int TYPE_SEND=1;

    /** 内容*/
    private String Content;
    /** 类型*/
    private int Type;


    public Msg(String content, int type) {
        Content = content;
        Type = type;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "Content='" + Content + '\'' +
                ", Type=" + Type +
                '}';
    }
}
