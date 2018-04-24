package com.example.administrator.master_view.bean;

/**
 * Created by Administrator on 2018/1/24.
 */

public class Fruits {
    private String name;
    private int imageId;

    public Fruits(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
