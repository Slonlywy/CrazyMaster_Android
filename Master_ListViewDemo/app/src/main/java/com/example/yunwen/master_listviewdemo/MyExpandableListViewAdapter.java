package com.example.yunwen.master_listviewdemo;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 黄伟嘉 on 2018/3/14.
 */

public class MyExpandableListViewAdapter extends BaseExpandableListAdapter {

    //上下文
    private Context mContext;
    //分组数据
    private String[] mGroupStrings;
    //子分组数据
    private String[][] mChildStrings;

    private SparseArray<ImageView> mIndicatorList=new SparseArray<>();

    //            根据分组的展开闭合状态设置指示器
    public void setIndicatorState(int groupPosition, boolean isExpanded) {
        if (isExpanded) {
            mIndicatorList.get(groupPosition).setImageResource(R.mipmap.down);
        } else {
            mIndicatorList.get(groupPosition).setImageResource(R.mipmap.right);
        }
    }


    public MyExpandableListViewAdapter(Context context, String[] groupStrings, String[][] childStrings) {
        mContext = context;
        mGroupStrings = groupStrings;
        mChildStrings = childStrings;
    }

    /**
     * 获取分组的个数
     *
     * @return
     */
    @Override
    public int getGroupCount() {
        return mGroupStrings.length;
    }

    /**
     * 获取指定分组的子选项的个数
     *
     * @param groupPosition 指定位置的分组
     * @return
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        return mChildStrings[groupPosition].length;
    }

    /**
     * 获取指定分组的数据
     *
     * @param groupPosition
     * @return
     */
    @Override
    public Object getGroup(int groupPosition) {
        return mGroupStrings[groupPosition];
    }

    /**
     * 获取指定分组中指定子选项的数据
     *
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mChildStrings[groupPosition][childPosition];
    }

    /**
     * 获取指定分组的ID, 这个ID必须是唯一的
     *
     * @param groupPosition
     * @return
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * 获取子选项的ID, 这个ID必须是唯一的
     *
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //        分组和子选项是否持有稳定的ID, 就是说底层数据的改变会不会影响到它们
    @Override
    public boolean hasStableIds() {
        return true;
    }


    /**
     * 获取显示指定分组的视图
     *
     * @param groupPosition
     * @param isExpanded
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder mGroupViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_expand_group, parent, false);
            mGroupViewHolder = new GroupViewHolder(convertView);
            convertView.setTag(mGroupViewHolder);
        } else {
            mGroupViewHolder = (GroupViewHolder) convertView.getTag();
        }

        mGroupViewHolder.mTv_expand_group.setText(mGroupStrings[groupPosition]);
        mIndicatorList.put(groupPosition,mGroupViewHolder.mIv_indicator);
        setIndicatorState(groupPosition,isExpanded);
        return convertView;
    }

    /**
     * 获取显示指定分组中的指定子选项的视图
     *
     * @param groupPosition
     * @param childPosition
     * @param isLastChild
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder mChildViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_expand_child, parent, false);
            mChildViewHolder=new ChildViewHolder(convertView);
            convertView.setTag(mChildViewHolder);
        }else {
            mChildViewHolder= (ChildViewHolder) convertView.getTag();
        }
        mChildViewHolder.mTv_expand_child.setText(mChildStrings[groupPosition][childPosition]);
        return convertView;
    }

    //        指定位置上的子元素是否可选中
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    private class GroupViewHolder {
        private TextView mTv_expand_group;
        private ImageView mIv_indicator;

        public GroupViewHolder(View view) {
            mTv_expand_group = (TextView) view.findViewById(R.id.label_expand_group);
            mIv_indicator = (ImageView) view.findViewById(R.id.iv_indicator);
        }
    }


    private class ChildViewHolder {
        private TextView mTv_expand_child;

        public ChildViewHolder(View view) {
            mTv_expand_child = (TextView) view.findViewById(R.id.label_expand_child);
        }
    }
}
