package com.example.yunwen.master_richtext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.yunwen.master_richtext.richText.RichImageView;
import com.example.yunwen.master_richtext.richText.RichText;

public class MainActivity extends AppCompatActivity implements RichImageView.OnClickListener, RichImageView.OnLongClickListener {

    private RichText mRichtext;
    private RichImageView mRich_image_view;

    String[] names={"123","222","333"};
    String pic_url="http://v4.faqrobot.net/upload/web/1499745285789327/20170711/67411499757212973.jpg";
    String[] pics={pic_url,pic_url,pic_url};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRichtext = (RichText) findViewById(R.id.rich_text);
        mRich_image_view = (RichImageView) findViewById(R.id.rich_image_view);


        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.zhaolvshi);


        mRich_image_view.onSetData(2,this,this);

        mRichtext.text("111112222222222");
    }

    @Override
    public void onClick(View view, int position) {

    }

    @Override
    public String upLoadPic(int position) {
        return pics[position];
    }

    @Override
    public String onViewMessage(int position) {
        return names[position];
    }

    @Override
    public boolean onLongClick(View view, int position) {
        return false;
    }
}
