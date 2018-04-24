package com.example.yunwen.master_richtext.richText;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yunwen.master_richtext.R;


/**
 * 富文本展示
 * Created by housh on 2017/5/3.
 */

public class RichImageView extends LinearLayout {
    private static final String TAG = "RichImageView";

    public RichImageView(Context context) {
        this(context, null);
    }

    public RichImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RichImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 进行配置当前的页面内容
     */
    public void onSetData(int size, final OnClickListener onClickListener, final OnLongClickListener onLongClickListener) {
        Log.i(TAG, "设置当前多图文的内容");
        //设置数据后进行显示
        this.setVisibility(VISIBLE);
        //设置垂直显示
        this.setOrientation(LinearLayout.VERTICAL);
        LayoutInflater from = LayoutInflater.from(this.getContext());
        RelativeLayout mHeadView = (RelativeLayout) from.inflate(R.layout.cs_rich_image_head, null);
        TextView mHeadContent = (TextView) mHeadView.findViewById(R.id.tv_rich_image_head);
        ImageView mHeadImageView = (ImageView) mHeadView.findViewById(R.id.iv_rich_image_head);
        mHeadContent.setText(onClickListener.onViewMessage(0));
        onLoadImageView(onClickListener, mHeadImageView, 0);
        mHeadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(v, 0);
            }
        });
        mHeadView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return onLongClickListener.onLongClick(v, 0);
            }
        });
        if (size > 1) {
            for (int i = 1; i < size; i++) {
                //每遍历一次进行增加单条数据
                RelativeLayout mRelative = (RelativeLayout) from.inflate(R.layout.cs_rich_image, null);
                TextView mContent = (TextView) mRelative.findViewById(R.id.tv_rich_image);
                ImageView mNumber = (ImageView) mRelative.findViewById(R.id.iv_rich_image);
                mContent.setText(onClickListener.onViewMessage(i));
                //增加到父Relative
                //对父容器进行增加子视图
                addView(mRelative);
                final int finalI = i;
                onLoadImageView(onClickListener, mHeadImageView, i);
                mContent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onClick(v, finalI);
                    }
                });
                mContent.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        return onLongClickListener.onLongClick(v, finalI);
                    }
                });
            }
        }
    }

    /**
     * 进行加载当前的视图
     */
    private void onLoadImageView(OnClickListener onClickListener, ImageView mHeadImageView, int position) {
        //加载当前的视图
        Glide.with(this.getContext()).load(onClickListener.upLoadPic(position)).into(mHeadImageView);
    }


    public interface OnClickListener {
        //点击图片
        void onClick(View view, int position);

        //更新图片
        String upLoadPic(int position);

        //展示消息
        String onViewMessage(int position);
    }

    public interface OnLongClickListener {
        boolean onLongClick(View view, int position);
    }


}
