package com.example.yunwen.master_htmlparse_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String html = "<html><head><title>First parse</title></head>"
            + "<body><p>Parsed HTML into a doc.</p></body></html>";

    String html_body = "<div><p>Lorem ipsum.</p>";


    private TextView mTv_show_html,mTv_show,mTv_show_head,mTv_show_body,mTv_show_title,mTv_show_result;
    private Button mBt_parse;
    private Button mBt_parse_body;
    private Button mBt_parse_url;
    private Button mBt_hezhang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        mBt_parse.setOnClickListener(this);
        mBt_parse_body.setOnClickListener(this);
        mBt_parse_url.setOnClickListener(this);
        mBt_hezhang.setOnClickListener(this);
    }

    private void initView() {
        mBt_parse = (Button) findViewById(R.id.bt_parse);
        mBt_parse_body = (Button) findViewById(R.id.bt_parse_body);
        mBt_parse_url = (Button) findViewById(R.id.bt_parse_Url);
        mBt_hezhang = (Button) findViewById(R.id.bt_parse_hezhang);

        mTv_show = (TextView) findViewById(R.id.tv_show);
        mTv_show_html = (TextView) findViewById(R.id.tv_show_html);
        mTv_show_head= (TextView) findViewById(R.id.tv_show_head);
        mTv_show_body = (TextView) findViewById(R.id.tv_show_body);
        mTv_show_title = (TextView) findViewById(R.id.tv_show_title);
        mTv_show_result = (TextView) findViewById(R.id.tv_show_result);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_parse:
                parseString();
                break;
            case R.id.bt_parse_body:
                parseBody();
                break;
            case R.id.bt_parse_Url:
                parseFromUrl();
                break;
            case R.id.bt_parse_hezhang:
                startActivity(new Intent(this,HeZhangTestActivity.class));
                break;
        }
    }

    /**
     * 从一个网站获取和解析一个HTML文档，并查找其中的相关数据
     */
    private void parseFromUrl() {
      /*  Document doc = null;
        try {
            doc = Jsoup.connect("http://example.com/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Document doc = null;
                try {
                    doc = Jsoup.connect("http://example.com")
                            .data("query", "Java")
                            .userAgent("Mozilla")
                            .cookie("auth", "token")
                            .timeout(3000)
                            .post();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mTv_show_result.setText(doc.toString());
            }
        });
    }

    private void parseBody() {
        mTv_show.setText(html_body);
        Document doc = Jsoup.parseBodyFragment(html_body);
        Element body = doc.body();   //将解析的文档插入到body中<body>...// </body>
        mTv_show_result.setText(body.toString());
    }

    private void parseString() {
        mTv_show.setText(html);
        Document parse = Jsoup.parse(html);
        mTv_show_result.setText("解析结果："+parse.toString());
        mTv_show_html.setText("html："+parse.html());
        mTv_show_head.setText("解析head："+parse.head().toString());
        mTv_show_body.setText("解析body："+parse.body().toString());
        mTv_show_title.setText("解析标题："+parse.title());
    }
}
