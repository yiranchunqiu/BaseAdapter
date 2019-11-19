package com.pxz.baseadapter;

import android.content.Context;
import android.widget.TextView;

import com.pxz.pxzadapter.rv.CommonAdapter;
import com.pxz.pxzadapter.rv.CommonHolder;

import java.util.List;

/**
 * 类说明：recyclerAdapter
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/19 16:06
 */
public class Recycler1Adapter extends CommonAdapter<String> {
    /**
     * 构造方法
     *
     * @param context 上下文
     * @param datas   数据源
     */
    public Recycler1Adapter(Context context, List<String> datas) {
        super(context, datas, R.layout.item_recycler_1);
    }

    @Override
    public void bindHolder(int position, CommonHolder holder, String s) {
        TextView tvItem = holder.getView(R.id.tv_item);
        tvItem.setText(s);
    }
}