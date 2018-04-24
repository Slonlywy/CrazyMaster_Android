package com.example.administrator.master_view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.master_view.R;
import com.example.administrator.master_view.bean.Fruits;

import java.util.List;

/**
 * Created by Administrator on 2018/1/25.
 */

public class FruitRecyclerViewAdapter extends RecyclerView.Adapter<FruitRecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private List<Fruits> mFruitsList;

    /**
     * 有参构造
     * @param context
     * @param list
     */
    public FruitRecyclerViewAdapter(Context context,List<Fruits> list) {
        mContext = context;
        mFruitsList=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_listview_fruit, null);
        final ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.mIv_fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int adapterPosition = viewHolder.getAdapterPosition();
                Fruits fruits = mFruitsList.get(adapterPosition);
                Toast.makeText(mContext, "点击了"+fruits.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.mTv_fruitname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int adapterPosition = viewHolder.getAdapterPosition();
                Fruits fruits = mFruitsList.get(adapterPosition);
                Toast.makeText(mContext, "点击了"+fruits.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruits fruits = mFruitsList.get(position);
        holder.mIv_fruit.setImageResource(fruits.getImageId());
        holder.mTv_fruitname.setText(fruits.getName());
    }

    /**
     * Item数量 由传入集合大小决定
     * @return
     */
    @Override
    public int getItemCount() {
        return mFruitsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView mIv_fruit;
        private final TextView mTv_fruitname;

        public ViewHolder(View itemView) {
            super(itemView);
            mIv_fruit = (ImageView) itemView.findViewById(R.id.iv_fruit);
            mTv_fruitname = (TextView) itemView.findViewById(R.id.tv_fruitname);
        }
    }
}
