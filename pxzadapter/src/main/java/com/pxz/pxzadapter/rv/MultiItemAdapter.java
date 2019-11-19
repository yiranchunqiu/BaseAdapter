package com.pxz.pxzadapter.rv;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

/**
 * 类说明：多种 item 布局adapter
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @time 2019/6/5 17:29
 */
public abstract class MultiItemAdapter<T> extends CommonAdapter<T> {
    private MultiItemTypeSupport<T> mMultiItemTypeSupport;

    /**
     * 构造方法
     *
     * @param datas                数据
     * @param context              上下文
     * @param multiItemTypeSupport 多种 item 布局支持接口
     */
    public MultiItemAdapter(Context context, List<T> datas, MultiItemTypeSupport<T> multiItemTypeSupport) {
        super(context, datas, -1);
        mMultiItemTypeSupport = multiItemTypeSupport;
    }

    @Override
    public int getItemViewType(int position) {
        return mMultiItemTypeSupport.getItemViewType(position, (T) mDatas.get(position));
    }

    @Override
    public CommonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = mMultiItemTypeSupport.getLayoutId(viewType);
        CommonHolder holder = CommonHolder.getHolder(mContext, parent, layoutId);
        return holder;
    }
}