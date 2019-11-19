package com.pxz.pxzadapter.rv;

/**
 * 类说明：多种 item 布局支持接口
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @time 2019/6/5 17:29
 */
public interface MultiItemTypeSupport<T> {
    /**
     * 根据不同的 itemtype 获取不同类型的布局文件
     * @param itemType 状态码
     * @return 不同布局
     */
    int getLayoutId(int itemType);

    /**
     * 根据不同 position 的 bean 生成不同的的 item 布局
     * @param position position
     * @param t 多种不同 item 传入的 bean 数据
     * @return type
     */
    int getItemViewType(int position, T t);
}