package net.ingx.material.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.ingx.materialdemo.R;

/**
 * @author admin
 * @version 1.0
 * @date 创建时间：2017/12/15
 * @action
 */
public class ComRecyclerAdapter extends RecyclerView.Adapter<ComRecyclerAdapter.ViewHolder> {
    public String[] datas = new String[]{"这是一个针对技术开发者的一个应用", "端以至于产品和设计都有涉猎，想成为全",
            "你可以在掘金上获取最新最优质的", "w的SDK，它的灵活性与可替代性比listview更好。接", "都是仅仅维护少量的View并且可",
            "Manager来确定每一个item的排列方式。", "Manager和添加删除动画，RecyclerVie", "之前，你需要一个继承自Recycle"
            , "ById方法（与ListView原理类似）", "用来确定每一个item如何进行排列摆放，何时展示和",
            "接下来几节中将会介绍更多RecyclerView的", "加依赖，然后同步一下就可以引入依赖包：", "方法，在接下来几节中将会介",
            "d方法（与ListView原理", "inearLayoutManager,",
            "是一个最简单的使用方法，在接下来几节中将会介绍", "yclerView的别的一些屌爆的", "向适配器请求新的数据来替换旧的数据，这种",
            "MyAdapter extends RecyclerView.Adapter<MyAdapte", "承自RecyclerView.Adapter的适配器", "（与ListView原理类似）。",
            "免了创建过多的View和频繁的调", "术开发者的一个应用，你可以在掘金上获取最新最优", "都有涉猎，想成为全栈工程师的朋",
            "方在于：翻译出来的句子还", "章讲解如何使用RecyclerView,彻底抛弃"};


    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_content, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mTextView.setText(datas[position]);
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.length;
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.item_content_txt);
        }
    }
}