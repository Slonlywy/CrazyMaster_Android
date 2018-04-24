package com.example.administrator.master_view.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.administrator.master_view.R;
import com.example.administrator.master_view.adapter.FruitRecyclerViewAdapter;
import com.example.administrator.master_view.bean.Fruits;

import java.util.ArrayList;
import java.util.List;

public class Demo_RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Fruits> mFruitsList=new ArrayList<>();
    private FruitRecyclerViewAdapter mFruitRecyclerViewAdapter;
    int[] imageResources={R.drawable.apple,R.drawable.lizi,R.drawable.orangle,R.drawable.xiangjiao};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo__recycler_view);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        initList();
        mFruitRecyclerViewAdapter = new FruitRecyclerViewAdapter(this, mFruitsList);
        /** 指定recyclerview的布局方向 不添加不显示数据*/
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this));  指定方向为线性
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));  指定方向为网格类型，且每行显示2列
        //指定类型为瀑布流形式，指定方向为Vertical则每行显示2列；指定方向为Horizontal时则显示2列
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL));
        mRecyclerView.setAdapter(mFruitRecyclerViewAdapter);
    }

    private void initList() {
        for (int i = 0; i < 200; i++) {
            if (i%4==0){
                Fruits apple = new Fruits("Apple", imageResources[0]);
                mFruitsList.add(apple);
            }else if(i%4==1){
                Fruits LiZi = new Fruits("LiZi", imageResources[1]);
                mFruitsList.add(LiZi);
            }else if (i%4==2){
                Fruits Orange = new Fruits("Orange", imageResources[2]);
                mFruitsList.add(Orange);
            }else {
                Fruits XiangJiao = new Fruits("XiangJiao", imageResources[3]);
                mFruitsList.add(XiangJiao);
            }
        }
    }


}
