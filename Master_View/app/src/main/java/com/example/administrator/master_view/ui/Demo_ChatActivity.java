package com.example.administrator.master_view.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.master_view.R;
import com.example.administrator.master_view.adapter.ChatRecyclerViewAdapter;
import com.example.administrator.master_view.bean.Msg;

import java.util.ArrayList;
import java.util.List;

public class Demo_ChatActivity extends AppCompatActivity {

    private Button mBt_changView;
    private LinearLayout mLl_chatView;
    private LinearLayout mNine_patch;
    private RecyclerView mRv_chat;
    private List<Msg> mMsgList=new ArrayList<>();
    private EditText mEt_sendcontent;
    private Button mBt_send;
    private ChatRecyclerViewAdapter mAdapter;
    private LinearLayout mLl_rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo__chat);
        initChangeView();
    }

    private void initChangeView() {
        mBt_changView = (Button) findViewById(R.id.bt_ChangeView);
        mLl_rv = (LinearLayout) findViewById(R.id.ll_rv);
        mNine_patch = (LinearLayout) findViewById(R.id.nine_patch);
        mBt_changView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNine_patch.setVisibility(View.GONE);
                mLl_rv.setVisibility(View.VISIBLE);
                startChat();
            }
        });
    }

    private void startChat() {
        initMsg();
        mEt_sendcontent = (EditText) findViewById(R.id.et_sendcontent);
        mBt_send = (Button) findViewById(R.id.bt_send);
        mRv_chat = (RecyclerView) findViewById(R.id.rv_chat);
        mAdapter = new ChatRecyclerViewAdapter(mMsgList, this);
        mRv_chat.setLayoutManager(new LinearLayoutManager(this));
        mRv_chat.setAdapter(mAdapter);

        mBt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = mEt_sendcontent.getText().toString().trim();
                if (!"".equals(content)){
                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    mMsgList.add(msg);
                    mAdapter.notifyItemInserted(mMsgList.size()-1);  //有消息时刷新
                    mRv_chat.scrollToPosition(mMsgList.size()-1);//滑动到最后一条
                    mEt_sendcontent.setText("");
                }else {
                    Toast.makeText(Demo_ChatActivity.this, "发送内容不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initMsg() {
        Msg msg = new Msg("Hello!", Msg.TYPE_RECEIVE);
        mMsgList.add(msg);
        Msg msg1 = new Msg("Hello!,Nice to meet you!", Msg.TYPE_SEND);
        mMsgList.add(msg1);
        Msg msg2 = new Msg("Nice to meet you too!", Msg.TYPE_RECEIVE);
        mMsgList.add(msg2);
    }
}


/** .9图片
 *  左边区域：指定可纵向拉伸的范围
 *  右边区域：指定该范围内的内容可以被拉伸，其他区域还保持原样
 *  顶部区域：指定可横向拉伸的范围
 *  底部区域：指定该范围内的内容可以被拉伸，其他区域还保持原样
 */
