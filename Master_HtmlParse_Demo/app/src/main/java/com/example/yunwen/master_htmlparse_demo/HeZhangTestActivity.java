package com.example.yunwen.master_htmlparse_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HeZhangTestActivity extends AppCompatActivity {

    String html_text = "普法依法治理办公室主任：翟理丽<br/>" +
            "<p style=\"text-align: center;\"><img width=\"162\" height=\"201\" title=\"67411499757212973.jpg\" style=\"width: 162px; height: 201px;\" alt=\"d9a50d3c-552b-4e88-98bb-880fe0d2211f.jpg\" src=\"http://v4.faqrobot.net/upload/web/1499745285789327/20170711/67411499757212973.jpg\"/></p>" +
            "<p style=\"text-align: center;\"><span style=\"font-size:18px;\"><strong>翟理丽 </strong>普法依法治理领导小组办公室主任</span></p><p>【工作分工】：</p>" +
            "<p style=\"margin: 0px;\"><span style=\"background: rgb(255, 255, 255); margin: 0px; color: rgb(105, 105, 105); text-transform: none; letter-spacing: 0pt; font-family: 仿宋; font-size: 15pt; font-style: normal; font-weight: normal;\"><span style=\"font-family:仿宋\">分管法制宣传股、普法办，负责普法依法治理、依法行政及涉及的相关工作。</span></span></p>" +
            "<p>【简 &nbsp; &nbsp; &nbsp; 历】：</p>" +
            "<p><span style=\"font-size:18px;\">&nbsp; &nbsp; &nbsp;&nbsp; 1994.09 -- 1997.05 中共贵州省委党校函授大专法律专业学习</span></p>" +
            "<p><span style=\"font-size:18px;\">　　1997.05 -- 2000.12 待业</span></p>" +
            "<p><span style=\"font-size:18px;\">　　2000.12 -- 2001.12 贵州省赫章县司法局古基司法所工作员</span></p>" +
            "<p><span style=\"font-size:18px;\">　　2002.02 -- 2004.12 贵州省赫章县司法局古基司法所科员</span></p>" +
            "<p><span style=\"font-size:18px;\">　　2013.08 -- 2015.03 贵州省赫章县司法局白果司法所所长</span></p>" +
            "<p><span style=\"font-size:18px;\">　　2015.03-- 赫章县普法依法治理工作领导小组办公室主任</span></p>" +
            "<p>" +
            "<br/>" +
            "</p>";
    private TextView mTv_showHezhang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_he_zhang_test);
        mTv_showHezhang = (TextView) findViewById(R.id.show_hezhang);


        Document document = Jsoup.parseBodyFragment(html_text);
        Element body = document.body();
        String html = body.html();
        /*Elements p = parse.select("p");
        StringBuilder stringBuilder = new StringBuilder();

        Elements src = p.select("img[src]");

        for (int i = 0; i < src.size(); i++) {
            Log.e("获取的图片src：",src.get(i).attr("src"));
        }



        for (int i = 0; i < p.size(); i++) {
            String trim = p.get(i).text().trim();
            stringBuilder.append(trim+"\n");
        }*/
        mTv_showHezhang.setText(html);
    }
}
