package com.example.yunwen.master_richtext;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import jp.wasabeef.richeditor.RichEditor;

public class RichTextEditorActivity extends AppCompatActivity {

    private RichEditor mRichEditor;


   String url= "http://v4.faqrobot.net/servlet/WBShow?action=sac&wbId=-100&sysNum=1499745285789327&FromUserName=2695F84B4F863D43FEDFC01F0DF6B2A6&sId=296333&subId=197535";

    String pic_url="http://v4.faqrobot.net/upload/web/1499745285789327/20170711/67411499757212973.jpg";

    String content="翟理丽 普法依法治理领导小组办公室主任【工作分工】：分管法制宣传股、普法办，负责普法依法治理、依法行政及涉及的相关工作。【简       历】：       1994.09 -- 1997.05 中共贵州省委党校函授大专法律专业学习　　1997.05 -- 2000.12 待业　　2000.12 -- 2001.12 贵州省赫章县司法局古基司法所工作员　　2002.02 -- 2004.12 贵州...\n" +
            "03-30 09:20:10.260 21141-21141/com.example.administrator.hezhangjudicialv2 D/ViseLog: ║ 点击查看详细>>";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rich_text_editor);


        String html="<html><body>"+content+"<html><body>";

        mRichEditor = (RichEditor) findViewById(R.id.rich_editor);

        mRichEditor.setEditorWidth(200);
        mRichEditor.setTextColor(Color.BLACK);
        mRichEditor.setFontSize(22);
        mRichEditor.setAlignLeft();
        mRichEditor.setBold();
        mRichEditor.setItalic();
        mRichEditor.insertImage(pic_url,"image");

    }


    public void onInsertImage(View view){

    }
}
