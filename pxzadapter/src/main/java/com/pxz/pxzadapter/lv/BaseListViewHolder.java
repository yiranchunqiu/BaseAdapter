package com.pxz.pxzadapter.lv;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 类说明：listivew通用视图容器
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @time 2019/6/5 17:24
 */
public class BaseListViewHolder {
    private final SparseArray<View> mViews;
    private View mConvertView;
    private ViewGroup mParent;

    private BaseListViewHolder(Context context, ViewGroup parent, int layoutId) {
        this.mParent = parent;
        this.mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    /**
     * 拿到一个ViewHolder对象
     */
    public static BaseListViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId) {
        if (convertView == null) {
            return new BaseListViewHolder(context, parent, layoutId);
        }
        return (BaseListViewHolder) convertView.getTag();
    }

    public View getConvertView() {
        return mConvertView;
    }

    public ViewGroup getParent() {
        return mParent;
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 为TextView设置字符串
     */
    public BaseListViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 为TextView设置具有样式的字符串
     */
    public BaseListViewHolder setText(int viewId, CharSequence text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 为ImageView设置图片
     */
    public BaseListViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);
        return this;
    }

    /**
     * 为ImageView设置图片
     */
    public BaseListViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }
}