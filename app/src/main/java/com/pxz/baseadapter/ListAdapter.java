package com.pxz.baseadapter;

import android.content.Context;
import android.widget.TextView;

import com.pxz.pxzadapter.lv.BaseListAdapter;
import com.pxz.pxzadapter.lv.BaseListViewHolder;

import java.util.List;

/**
 * 类说明：listAdapter
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/19 15:51
 */
public class ListAdapter extends BaseListAdapter<String> {
    /**
     * 构造方法
     *
     * @param context      上下文
     * @param mDatas       数据源
     */
    public ListAdapter(Context context, List<String> mDatas) {
        super(context, mDatas, R.layout.item_list);
    }

    @Override
    public void convert(int position, BaseListViewHolder helper, String item) {
        TextView tvItem=helper.getView(R.id.tv_item);
        tvItem.setText(item);
    }
}