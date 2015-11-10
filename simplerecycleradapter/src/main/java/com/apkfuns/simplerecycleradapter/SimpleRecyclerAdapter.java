package com.apkfuns.simplerecycleradapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by pengwei08 on 15/11/3.
 * 通用的recyclerView适配器
 */
public abstract class SimpleRecyclerAdapter<T> extends RecyclerView.Adapter {

    private List<T> mList = new ArrayList<>();

    public SimpleRecyclerAdapter(List<T> list) {
        addAll(list);
    }

    public SimpleRecyclerAdapter(T[] array) {
        if (array != null) {
            addAll(Arrays.asList(array));
        }
    }

    /**
     * 设置Item资源文件
     *
     * @return
     */
    public abstract int getLayoutRes();

    /**
     * 设置每项的值
     *
     * @param holder
     * @param position
     * @param t
     */
    public abstract void onBindView(RVHolder holder, int position, T t);


    /**
     * 每项的点击事件
     *
     * @param holder
     * @param view
     * @param position
     * @param item
     */
    public void onItemClick(RVHolder holder, View view, int position, T item) {

    }

    /**
     * 导入布局
     *
     * @param viewGroup
     * @param viewType
     * @return
     */
    protected View inflateItemView(ViewGroup viewGroup, int viewType) {
        return null;
    }

    @Override
    public RVHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View content = LayoutInflater.from(parent.getContext()).inflate(getLayoutRes(), parent, false);
        Log.d("**test", "**" + viewType);
        return new RVHolder(content);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        onBindView((RVHolder) holder, position, mList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick((RVHolder) holder, v, position, mList.get(position));
            }
        });
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 10000;
    }

    /**
     * 增加集合
     *
     * @param collection
     */
    public void addAll(Collection<T> collection) {
        if (collection != null && collection.size() > 0) {
            mList.addAll(collection);
            notifyDataSetChanged();
        }
    }

    /**
     * 增加元素
     * @param t
     */
    public void add(T t){
        if (t != null){
            mList.add(t);
            notifyItemInserted(0);
        }
    }

    /**
     * 清理
     */
    public void clear() {
        mList.clear();
    }
}


