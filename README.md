# 介绍
## 自用项目，baseadapter(包含baselist和baserecycler)

### 图片
<div style="align: center">
       <img src="https://github.com/yiranchunqiu/BaseAdapter/blob/master/pic/%E5%9B%BE%E7%89%871.png" width="32%">
       <img src="https://github.com/yiranchunqiu/BaseAdapter/blob/master/pic/%E5%9B%BE%E7%89%872.png" width="32%">
       <img src="https://github.com/yiranchunqiu/BaseAdapter/blob/master/pic/%E5%9B%BE%E7%89%873.png" width="32%">
</div>


### 使用方法
### 添加

```
allprojects {
 		repositories {
 			maven { url 'https://jitpack.io' }
 		}
 	}
```

### 添加依赖

```
 	dependencies {
    	        implementation 'com.github.yiranchunqiu:BaseAdapter:1.0'
    	}
```

### 使用
#####
对listadapter进行二次封装
***
对recycleradapter进行二次封装，CommonAdapter普通的adapter,MultiItemAdapter多布局的adapter

```

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

```
***
```
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
```
***

```
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
```