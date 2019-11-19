package com.pxz.pxzadapter.rv;

import android.view.View;

/**
 * 类说明：点击监听接口
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @time 2019/6/5 17:29
 */
public interface OnItemClickListener {
    /**
     * 点击监听接口
     */
    void onItemClick(View view, int position);

    /**
     * 长按监听接口
     */
    void onItemLongClick(View view, int position);
}