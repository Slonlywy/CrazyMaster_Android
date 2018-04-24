package com.example.administrator.master_view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.master_view.R;
import com.example.administrator.master_view.bean.Msg;

import java.util.List;

/**
 * Created by 黄伟嘉 on 2018/1/27.
 */

public class ChatRecyclerViewAdapter extends RecyclerView.Adapter<ChatRecyclerViewAdapter.ViewHolder> {

    private List<Msg> mMsgList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public ChatRecyclerViewAdapter(List<Msg> msgList, Context context) {
        mMsgList = msgList;
        mContext = context;
        mLayoutInflater=LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_msg, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg = mMsgList.get(position);
        if (msg.getType()==Msg.TYPE_RECEIVE){
           holder.mLeftLayout.setVisibility(View.VISIBLE);
            holder.mRightLayout.setVisibility(View.GONE);
            holder.mTv_left.setText(msg.getContent());
        }else if (msg.getType()==Msg.TYPE_SEND){
            holder.mLeftLayout.setVisibility(View.GONE);
            holder.mRightLayout.setVisibility(View.VISIBLE);
            holder.mTv_right.setText(msg.getContent());
        }
    }


    @Override
    public int getItemCount() {
        return mMsgList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final LinearLayout mLeftLayout;
        private final TextView mTv_left;
        private final LinearLayout mRightLayout;
        private final TextView mTv_right;

        public ViewHolder(View itemView) {
            super(itemView);
            mLeftLayout = (LinearLayout) itemView.findViewById(R.id.ll_left);
            mTv_left = (TextView) itemView.findViewById(R.id.tv_left);
            mRightLayout = (LinearLayout) itemView.findViewById(R.id.ll_right);
            mTv_right = (TextView) itemView.findViewById(R.id.tv_right);
        }
    }
}
