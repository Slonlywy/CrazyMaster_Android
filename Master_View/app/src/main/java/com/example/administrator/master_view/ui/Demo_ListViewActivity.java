package com.example.administrator.master_view.ui;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.master_view.R;
import com.example.administrator.master_view.adapter.FruitAdapter;
import com.example.administrator.master_view.bean.Fruits;

import java.util.ArrayList;
import java.util.List;

public class Demo_ListViewActivity extends AppCompatActivity {

    private ListView mListView;
    private ListView mLv_arrayadapter;
    private ArrayAdapter<String> mAdapter;
    private ListView mLv_custom;

    int[] imageResources={R.drawable.apple,R.drawable.lizi,R.drawable.orangle,R.drawable.xiangjiao};
    private ArrayList<Fruits> mFruits_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo__list_view);
        initListView1();
        initListView_ArrayAdapter();
        initListView_Fruits();
    }

    private void initListView_Fruits() {
        mFruits_list = new ArrayList<>();
        initFruitsList();
        mLv_custom = (ListView) findViewById(R.id.listview_custom);
        FruitAdapter fruitAdapter = new FruitAdapter(this, R.layout.item_listview_fruit, mFruits_list);
        mLv_custom.setAdapter(fruitAdapter);

        /**
         * item点击事件
         */
        mLv_custom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Fruits fruits = mFruits_list.get(position);
                new AlertDialog.Builder(Demo_ListViewActivity.this).setMessage(fruits.getName())
                        .setCancelable(true).show();
            }
        });
    }

    private void initFruitsList() {
        for (int i = 0; i <200; i++) {
              if (i%4==0){
                  Fruits apple = new Fruits("Apple", imageResources[0]);
                  mFruits_list.add(apple);
              }else if(i%4==1){
                  Fruits LiZi = new Fruits("LiZi", imageResources[1]);
                  mFruits_list.add(LiZi);
              }else if (i%4==2){
                  Fruits Orange = new Fruits("Orange", imageResources[2]);
                  mFruits_list.add(Orange);
              }else {
                  Fruits XiangJiao = new Fruits("XiangJiao", imageResources[3]);
                  mFruits_list.add(XiangJiao);
              }
        }
    }

    private void initListView_ArrayAdapter() {
        mLv_arrayadapter = (ListView) findViewById(R.id.listview_arrayadapter);
        String[] arr_lv={"孙悟空","猪八戒","妖怪哪里跑~！~~~~~"};

        mAdapter = new ArrayAdapter<>(this, R.layout.item_listview_arrayadapter, arr_lv);
        mLv_arrayadapter.setAdapter(mAdapter);
    }

    private void initListView1() {
        mListView = (ListView) findViewById(R.id.listview);
        mListView.setHeaderDividersEnabled(true);
        mListView.setFooterDividersEnabled(false);
    }
}
