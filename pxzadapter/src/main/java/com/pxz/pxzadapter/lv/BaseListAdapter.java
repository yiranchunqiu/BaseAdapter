package com.pxz.pxzadapter.lv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 类说明：listviewAdapter基类
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @time 2019/6/5 17:23
 */
public abstract class BaseListAdapter<T> extends BaseAdapter {
    /**
     * 布局管理器
     */
    protected LayoutInflater mInflater;
    /**
     * 上下文
     */
    protected Context mContext;
    /**
     * 数据
     */
    protected List<T> mDatas;
    /**
     * 布局
     */
    protected final int mItemLayoutId;

    /**
     * 构造方法
     *
     * @param context      上下文
     * @param mDatas       数据源
     * @param itemLayoutId 布局
     */
    public BaseListAdapter(Context context, List<T> mDatas, int itemLayoutId) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        if (null == mDatas) {
            this.mDatas = new ArrayList<T>();
        } else {
            this.mDatas = mDatas;
        }
        this.mItemLayoutId = itemLayoutId;
    }

    @Override
    public int getCount() {
        if (null == mDatas) {
            return 0;
        } else {
            return mDatas.size();
        }
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 获取集合数据
     */
    public List<T> getmDatas() {
        return mDatas;
    }

    /**
     * 覆盖填充数据
     */
    public void setmDatas(List<T> mDatas) {
        this.mDatas = mDatas;
    }

    /**
     * 数据添加集合
     */
    public void addItems(List<T> items) {
        this.mDatas.addAll(items);
    }

    /**
     * 清除数据
     */
    public void clearData() {
        mDatas.clear();
    }

    /**
     * 删除最后一条数据
     */
    public void clearlastData() {
        if (null == mDatas) {
        } else {
            mDatas.remove(mDatas.get(mDatas.size() - 1));
        }
    }

    /**
     * 清除关于t的数据
     */
    public void delData(T t) {
        mDatas.remove(t);
    }

    /**
     * 清除位置在index+1的数据
     */
    public void delData(int index) {
        if (null == mDatas) {
        } else {
            mDatas.remove(index);
        }
    }

    /**
     * 当数据发送改变时，调用此方法，更新界面
     */
    public void changeData(List<T> items) {
        if (items != null) {
            this.mDatas = items;
            this.notifyDataSetChanged();
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final BaseListViewHolder viewHolder = getViewHolder(convertView, parent);
        convert(position, viewHolder, getItem(position));
        return viewHolder.getConvertView();
    }

    /**
     * 处理业务
     *
     * @param position position
     * @param helper   ViewHolder
     * @param item     数据
     */
    public abstract void convert(int position, BaseListViewHolder helper, T item);

    private BaseListViewHolder getViewHolder(View convertView, ViewGroup parent) {
        return BaseListViewHolder.get(mContext, convertView, parent, mItemLayoutId);
    }
}