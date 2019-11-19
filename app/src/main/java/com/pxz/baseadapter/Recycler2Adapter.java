package com.pxz.baseadapter;

import android.content.Context;
import android.widget.TextView;

import com.pxz.pxzadapter.rv.CommonHolder;
import com.pxz.pxzadapter.rv.MultiItemAdapter;
import com.pxz.pxzadapter.rv.MultiItemTypeSupport;

import java.util.List;

/**
 * 类说明：recyclerAdapter
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/19 16:06
 */
public class Recycler2Adapter extends MultiItemAdapter<TypeBean> {
    private static int TYPE1 = 1;
    private static int TYPE2 = 2;

    /**
     * 构造方法
     *
     * @param context              上下文
     * @param datas                数据
     */
    public Recycler2Adapter(Context context, List<TypeBean> datas) {
        super(context, datas,new MultiItemTypeSupport<TypeBean>() {
                    @Override
                    public int getLayoutId(int itemType) {
                        if (itemType == TYPE1) {
                            return R.layout.item_recycler_2_1;
                        } else if (itemType == TYPE2) {
                            return R.layout.item_recycler_2_2;
                        }
                        return R.layout.item_recycler_2_1;
                    }

                    @Override
                    public int getItemViewType(int position, TypeBean typeBean) {
                        if (typeBean.getType() == 1) {
                            return TYPE1;
                        } else if (typeBean.getType() == 2) {
                            return TYPE2;
                        }
                        return TYPE1;
                    }
                }
        );
    }

    @Override
    public void bindHolder(int position, CommonHolder holder, TypeBean typeBean) {
        if (holder.getItemViewType() == TYPE1) {
            TextView tvItem1 = holder.getView(R.id.tv_item);
            tvItem1.setText(typeBean.getType()+":"+typeBean.getString());
        } else if (holder.getItemViewType() == TYPE2) {
            TextView tvItem2 = holder.getView(R.id.tv_item);
            tvItem2.setText(typeBean.getType()+":"+typeBean.getString());
        }
    }
}