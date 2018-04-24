package com.example.administrator.master_view.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.master_view.R;
import com.example.administrator.master_view.customactivity.CircleActivity;
import com.example.administrator.master_view.customactivity.OvalActivity;
import com.example.administrator.master_view.customactivity.PathActivity;
import com.example.administrator.master_view.customactivity.RectActivity;
import com.example.administrator.master_view.customactivity.SectorActivity;
import com.example.administrator.master_view.customactivity.TrigonActivity;
import com.example.administrator.master_view.customactivity.TvIvActivity;

public class Demo_CustomViewActivity extends AppCompatActivity {

    private String[] mStringItems={"矩形","圆形","扇形","三角形","椭圆形","曲线","文字和图片"};
    private ListView mListView;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);

        mListView = (ListView) findViewById(R.id.listview);

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mStringItems);

        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(Demo_CustomViewActivity.this, RectActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(Demo_CustomViewActivity.this, CircleActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(Demo_CustomViewActivity.this, SectorActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(Demo_CustomViewActivity.this, TrigonActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(Demo_CustomViewActivity.this, OvalActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(Demo_CustomViewActivity.this, PathActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(Demo_CustomViewActivity.this, TvIvActivity.class));
                        break;
                }
            }
        });
    }
}
