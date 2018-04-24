package com.example.yunwen.master_listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class ExpandableListViewActivity extends AppCompatActivity implements ExpandableListView.OnGroupClickListener, ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {

    private ExpandableListView mElv;

    public String[] groupStrings = {"西游记", "水浒传", "三国演义", "红楼梦"};
    public String[][] childStrings = {
            {"唐三藏", "孙悟空", "猪八戒", "沙和尚"},
            {"宋江", "林冲", "李逵", "鲁智深"},
            {"曹操", "刘备", "孙权", "诸葛亮", "周瑜"},
            {"贾宝玉", "林黛玉", "薛宝钗", "王熙凤"}
    };
    private MyExpandableListViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mElv = (ExpandableListView) findViewById(R.id.elv);

        mAdapter = new MyExpandableListViewAdapter(this, groupStrings, childStrings);

        mElv.setAdapter(mAdapter);

        mElv.setOnGroupClickListener(this);
        mElv.setOnChildClickListener(this);
        mElv.setOnGroupCollapseListener(this);
        mElv.setOnGroupExpandListener(this);
    }

    /**
     * 分组点击事件
     *
     * @param expandableListView
     * @param view
     * @param groupPosition
     * @param l
     * @return
     */
    @Override
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
        Toast.makeText(this, "点击了分组：" + groupStrings[groupPosition], Toast.LENGTH_SHORT).show();
        //必须返回false，否则分组不会展开
        return false;
    }

    /**
     * 子选项点击事件
     *
     * @param expandableListView
     * @param view
     * @param groupPosition
     * @param childPosition
     * @param l
     * @return
     */
    @Override
    public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
        Toast.makeText(this, "点击了子选项：" + childStrings[groupPosition][childPosition], Toast.LENGTH_SHORT).show();
        return true;
    }


    /**
     * 分组合并监听
     *
     * @param position
     */
    @Override
    public void onGroupCollapse(int position) {
        Toast.makeText(this, "分组：" + groupStrings[position] + "合并了....", Toast.LENGTH_SHORT).show();
    }

    /**
     * 分组展开监听
     *
     * @param position
     */
    @Override
    public void onGroupExpand(int position) {
        Toast.makeText(this, "分组：" + groupStrings[position] + "展开了....", Toast.LENGTH_SHORT).show();
    }
}
