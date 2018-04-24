package com.example.administrator.master_view.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.master_view.R;
import com.example.administrator.master_view.bean.Fruits;

import java.util.List;

import static com.example.administrator.master_view.R.id.iv_fruit;
import static com.example.administrator.master_view.R.id.tv_fruitname;

/**
 * Created by Administrator on 2018/1/24.
 */

public class FruitAdapter extends ArrayAdapter<Fruits> {
    private int resourceItemId;
    private Context mContext;

    /**
     * 构造方法
     * @param context  上下文
     * @param LayoutResourceId  布局文件id资源
     * @param list   存放Fruits实体类集合
     */
    public FruitAdapter(Context context, int LayoutResourceId, List<Fruits> list){
        super(context,LayoutResourceId,list);
        this.mContext=context;
        this.resourceItemId=LayoutResourceId;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruits fruits = getItem(position);
        /** 缺陷：每次获取Item时 都要重新加载一次布局，当listview item数量增多时 可能快速滑动时会遇到瓶颈*/
//        View view = LayoutInflater.from(mContext).inflate(resourceItemId, parent, false);
        ViewHolder viewHolder;
        /**  优化：方法中有个convertView  该参数是用于将之前加载好的布局进行缓存 以便于后面使用*/
        if (convertView==null) {
            convertView = LayoutInflater.from(mContext).inflate(resourceItemId, parent, false);
            viewHolder=new ViewHolder(convertView);
            //将View和控件绑定在一起
            convertView.setTag(viewHolder);
        }else {
            //直接拿到绑定的
            viewHolder = (ViewHolder) convertView.getTag();
        }

        /** 缺陷：虽然解决每次重复加载布局，但是下面该部分每次都要重新findviewbyid；通过内部类ViewHolder来实例化*/
//        ImageView iv_fruit = (ImageView) view.findViewById(R.id.iv_fruit);
//        TextView tv_fruitname = (TextView) view.findViewById(R.id.tv_fruitname);
        viewHolder.iv_fruit.setImageResource(fruits.getImageId());
        viewHolder.tv_fruitname.setText(fruits.getName());
        return convertView;
    }


    class ViewHolder{
        ImageView iv_fruit;
        TextView tv_fruitname;

        public ViewHolder(View view){
            iv_fruit = (ImageView) view.findViewById(R.id.iv_fruit);
            tv_fruitname = (TextView) view.findViewById(R.id.tv_fruitname);
        }

    }
}
