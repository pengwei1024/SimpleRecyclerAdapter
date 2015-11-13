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

    private static final String TAG = "SimpleRecyclerAdapter";
    private List<T> mList = new ArrayList<>();
    private OnItemClickListener listener;
    private int defaultLayoutId;

    /*   ---------------构造方法--------------  */

    public SimpleRecyclerAdapter() {
        if (getDataList() != null) {
            addAll(getDataList());
        } else if (getDataArray() != null) {
            addAll(Arrays.asList(getDataArray()));
        }
    }

    public SimpleRecyclerAdapter(List<T> list) {
        addAll(list);
    }

    public SimpleRecyclerAdapter(T[] array) {
        if (array != null) {
            addAll(Arrays.asList(array));
        }
    }

    public SimpleRecyclerAdapter(int layoutId, List<T> list) {
        this(list);
        this.defaultLayoutId = layoutId;
    }

    public SimpleRecyclerAdapter(int layoutId, T[] array) {
        this(array);
        this.defaultLayoutId = layoutId;
    }



    /*   ---------------基本操作--------------  */

    /**
     * 设置Item资源文件
     *
     * @return
     */
    public int getLayoutRes() {
        return defaultLayoutId;
    }

    public List<T> getDataList() {
        return null;
    }

    public T[] getDataArray() {
        return null;
    }

    /**
     * 设置每项的值
     *
     * @param holder
     * @param position
     * @param t
     */
    public abstract void onBindView(RVHolder holder, int position, int itemViewType, T t);


    /**
     * 导入布局
     *
     * @param viewGroup
     * @return
     */
    protected final RVHolder createRVHolder(ViewGroup viewGroup, int layoutId) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, false);
        return new RVHolder(view);
    }

    protected final RVHolder createRVHolder(View view) {
        return new RVHolder(view);
    }

    @Override
    public RVHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        return createRVHolder(parent, getLayoutRes());
    }

    @Override
    public final void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick((RVHolder) holder, v, position, mList.get(position));
            }
        });
        try {
            onBindView((RVHolder) holder, position, holder.getItemViewType(), mList.get(position));
        } catch (IndexOutOfBoundsException e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    /*   ---------------数据操作--------------  */

    public List<T> getList() {
        return mList;
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
     *
     * @param t
     */
    public void add(T t) {
        if (t != null) {
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


    /*   ---------------事件监听--------------  */

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener<T> {
        void onItemClick(RecyclerView.ViewHolder holder, View view, int position, T item);
    }

    /**
     * 每项的点击事件
     *
     * @param holder
     * @param view
     * @param position
     * @param item
     */
    public void onItemClick(RVHolder holder, View view, int position, T item) {
        if (listener != null) {
            listener.onItemClick(holder, view, position, item);
        }
    }
}


