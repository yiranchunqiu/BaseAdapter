package com.pxz.pxzadapter.rv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * 类说明：RecyclerView 通用的 Adapter
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @time 2019/6/5 17:28
 */
public abstract class CommonAdapter<T> extends RecyclerView.Adapter<CommonHolder> {
    /**
     * 上下文
     */
    protected Context mContext;
    /**
     * 所有 item 的数据集合
     */
    protected List<T> mDatas;
    /**
     * item 布局文件 id
     */
    protected int mLayoutId;
    /**
     * 布局管理器
     */
    protected LayoutInflater mInflater;
    /**
     * 点击事件
     */
    protected OnItemClickListener mOnitemClickListener;

    /**
     * 构造方法
     *
     * @param context  上下文
     * @param datas    数据源
     * @param layoutId 布局
     */
    public CommonAdapter(Context context, List<T> datas, int layoutId) {
        mContext = context;
        mDatas = datas;
        mLayoutId = layoutId;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public CommonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CommonHolder holder = CommonHolder.getHolder(mContext, parent, mLayoutId);
        return holder;
    }

    @Override
    public void onBindViewHolder(final CommonHolder holder, int position) {
        if (mOnitemClickListener != null) {
            // 点击事件
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnitemClickListener.onItemClick(holder.itemView, position);
                }
            });
            // 长按事件
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnitemClickListener.onItemLongClick(holder.itemView, position);
                    return false;
                }
            });
        }
        bindHolder(position, holder, mDatas.get(position));
    }

    /**
     * BindHolder 绑定 view 给 view 赋值
     *
     * @param holder holder
     * @param t      holder 里面 view 赋值的数据
     */
    public abstract void bindHolder(int position, CommonHolder holder, T t);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    /**
     * 添加多条数据
     *
     * @param content 添加数据的内容
     */
    public void addDataAll(List<T> content) {
        mDatas.addAll(content);
        notifyDataSetChanged();
    }

    /**
     * 添加一条数据
     *
     * @param position 添加数据的位置
     * @param content  添加数据的内容
     */
    public void addData(int position, T content) {
        if (position >= 0) {
            mDatas.add(position, content);
            notifyItemInserted(position);
        }
    }

    /**
     * 删除一条数据
     *
     * @param position 删除数据的位置
     */
    public void removeData(int position) {
        if (position >= 0) {
            mDatas.remove(position);
            notifyItemRemoved(position);
        }
    }

    /**
     * 设置点击监听
     *
     * @param onitemClickListener 点击监听的接口
     */
    public void setOnitemClickListener(OnItemClickListener onitemClickListener) {
        this.mOnitemClickListener = onitemClickListener;
    }
}